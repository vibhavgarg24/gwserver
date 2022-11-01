package com.ayuvib.gwserver.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.exception.InvalidInputException;
import com.ayuvib.gwserver.model.Transaction;
import com.ayuvib.gwserver.model.User;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserDao userDao;

    @Override
    public Transaction add(String id, int cIndex, Transaction txn) {
        
        User user = this.userDao.findById(id).get();
        if (txn.getAmount() < 0 || cIndex < 0 || cIndex >= user.getCategories().size()) {
            throw new InvalidInputException("103", "Invalid inputs");
        }

        // add txn amount to total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() + txn.getAmount());
        double sum = user.getCategories().get(cIndex).getSum() + txn.getAmount();
        user.getCategories().get(cIndex).setSum(sum);

        user.getCategories().get(cIndex).getTxns().add(txn);

        this.userDao.save(user);
        return txn;
    }

    @Override
    public Transaction find(String id, int cIndex, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (cIndex < 0 || cIndex >= user.getCategories().size() || 
            tIndex < 0 || tIndex >= user.getCategories().get(cIndex).getTxns().size()) {
                throw new InvalidInputException("103", "Invalid inputs");
        }

        return user.getCategories().get(cIndex).getTxns().get(tIndex);
    }

    @Override
    public Transaction update(String id, int oldCIndex, int oldTIndex, int newCIndex, Transaction txn) {

        Transaction deletedTxn = delete(id, oldCIndex, oldTIndex);
        try {
            add(id, newCIndex, txn);
        } catch (Exception e) {
            add(id, oldCIndex, deletedTxn);
            throw e;
        }
        
        return txn;
    }

    @Override
    public Transaction delete(String id, int cIndex, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (cIndex < 0 || cIndex >= user.getCategories().size() || 
            tIndex < 0 || tIndex >= user.getCategories().get(cIndex).getTxns().size()) {
                throw new InvalidInputException("103", "Invalid inputs");
        }

        // get txn from cIndex tIndex
        double txnAmount = user.getCategories().get(cIndex).getTxns().get(tIndex).getAmount();
        double cSum = user.getCategories().get(cIndex).getSum();

        // set total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() - txnAmount);
        user.getCategories().get(cIndex).setSum(cSum - txnAmount);

        Transaction deletedTxn = user.getCategories().get(cIndex).getTxns().remove(tIndex);

        this.userDao.save(user);
        return deletedTxn;
    }
    
}
