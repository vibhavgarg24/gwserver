package com.ayuvib.gwserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.model.Transaction;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(){}

    @Override
    public ResponseEntity<?> findAll() {
        
        return ResponseEntity.ok(this.userDao.findAll());
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        
        return ResponseEntity.ok(this.userDao.findById(id).get());
    }

    @Override
    public ResponseEntity<?> addCategory(String categoryName) {
        
        return null;
    }

    @Override
    public ResponseEntity<?> getCategoryDetails(String category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> updateCategory(Category category) {
        
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCategory(String category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> addTransaction(Transaction txn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getTransactionDetails(String tId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> updateTransaction(Transaction txn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> deleteTransaction(String tId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
