package com.ayuvib.gwserver.service.transaction;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Transaction;

public interface TransactionService {

    public ResponseEntity<?> addTransaction(Transaction txn);

    public ResponseEntity<?> getTransactionDetails(String tId);

    public ResponseEntity<?> updateTransaction(Transaction txn);

    public ResponseEntity<?> deleteTransaction(String tId);
    
}
