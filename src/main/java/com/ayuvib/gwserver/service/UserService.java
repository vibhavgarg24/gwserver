package com.ayuvib.gwserver.service;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.model.Transaction;

public interface UserService {
    
    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById(String id);

    //Categories CRUD ---------------------
    public ResponseEntity<?> addCategory(String categoryName);

    public ResponseEntity<?> getCategoryDetails(String categoryName);

    public ResponseEntity<?> updateCategory(Category category);

    public ResponseEntity<?> deleteCategory(String categoryName);
    //----------------------

    //Transactions CRUD -------------------
    public ResponseEntity<?> addTransaction(Transaction txn);

    public ResponseEntity<?> getTransactionDetails(String tId);

    public ResponseEntity<?> updateTransaction(Transaction txn);

    public ResponseEntity<?> deleteTransaction(String tId);
    //----------------------
}
