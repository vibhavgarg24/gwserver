package com.ayuvib.gwserver.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.model.Transaction;
import com.ayuvib.gwserver.model.User;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<?> add(String id, int cIndex, Transaction txn) {
        
        User user = this.userDao.findById(id).get();
        if (txn.getAmount() < 0 || cIndex < 0 || cIndex >= user.getCategories().size()) {
            return ResponseEntity.ok(user);
        }

        // add txn amount to total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() + txn.getAmount());
        double sum = user.getCategories().get(cIndex).getSum() + txn.getAmount();
        user.getCategories().get(cIndex).setSum(sum);

        user.getCategories().get(cIndex).getTxns().add(txn);

        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> find(String id, int cIndex, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (cIndex < 0 || cIndex >= user.getCategories().size() || 
            tIndex < 0 || tIndex >= user.getCategories().get(cIndex).getTxns().size()) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(user.getCategories().get(cIndex).getTxns().get(tIndex));
    }

    @Override
    public ResponseEntity<?> update(String id, int oldCIndex, int oldTIndex, int newCIndex, Transaction txn) {

        delete(id, oldCIndex, oldTIndex);
        add(id, newCIndex, txn);
        
        User user = this.userDao.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<?> delete(String id, int cIndex, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (cIndex < 0 || cIndex >= user.getCategories().size() || 
            tIndex < 0 || tIndex >= user.getCategories().get(cIndex).getTxns().size()) {
            return ResponseEntity.ok(user);
        }

        // get txn from cIndex tIndex
        double txnAmount = user.getCategories().get(cIndex).getTxns().get(tIndex).getAmount();
        double cSum = user.getCategories().get(cIndex).getSum();

        // set total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() - txnAmount);
        user.getCategories().get(cIndex).setSum(cSum - txnAmount);

        user.getCategories().get(cIndex).getTxns().remove(tIndex);

        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }
    
}
