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
    public ResponseEntity<?> add(String id, Transaction txn) {
        
        User user = this.userDao.findById(id).get();
        if (txn.getAmount() < 0 || txn.getcIndex() < 0 || txn.getcIndex() >= user.getCategories().size()) {
            return ResponseEntity.ok(user);
        }

        // add txn amount to total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() + txn.getAmount());
        double sum = user.getCategories().get(txn.getcIndex()).getSum() + txn.getAmount();
        user.getCategories().get(txn.getcIndex()).setSum(sum);

        user.getTransactions().add(txn);

        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> find(String id, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (tIndex < 0 || tIndex >= user.getTransactions().size()) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(user.getTransactions().get(tIndex));
    }

    @Override
    public ResponseEntity<?> update(String id, int tIndex, Transaction txn) {

        User user = this.userDao.findById(id).get();
        if (txn.getAmount() < 0 || tIndex < 0 || tIndex >= user.getTransactions().size()) {
            return ResponseEntity.ok(user);
        }

        // get txn data of txn to be removed from tIndex
        double oldAmount = user.getTransactions().get(tIndex).getAmount();
        int oldCIndex = user.getTransactions().get(tIndex).getcIndex();

        user.setTotalSum(user.getTotalSum() - oldAmount + txn.getAmount());

        // set CSum of removed txn
        double oldCSum = user.getCategories().get(oldCIndex).getSum() - oldAmount;
        user.getCategories().get(oldCIndex).setSum(oldCSum);
        
        // set CSum of added txn
        double newCSum = user.getCategories().get(txn.getcIndex()).getSum() + txn.getAmount();
        user.getCategories().get(txn.getcIndex()).setSum(newCSum);

        user.getTransactions().set(tIndex, txn);
        
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> delete(String id, int tIndex) {
        
        User user = this.userDao.findById(id).get();
        if (tIndex < 0 || tIndex >= user.getTransactions().size()) {
            return ResponseEntity.ok(user);
        }

        // get txn data from tIndex
        double amount = user.getTransactions().get(tIndex).getAmount();
        int cIndex = user.getTransactions().get(tIndex).getcIndex();
        double oldCSum = user.getCategories().get(cIndex).getSum();

        // set total sum and corresponding category sum
        user.setTotalSum(user.getTotalSum() - amount);
        user.getCategories().get(cIndex).setSum(oldCSum - amount);

        user.getTransactions().remove(tIndex);

        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }
    
}
