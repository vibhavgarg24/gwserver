package com.ayuvib.gwserver.service.transaction;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Transaction;

public interface TransactionService {

    public ResponseEntity<?> add(String id, Transaction txn);

    public ResponseEntity<?> find(String id, int tIndex);

    public ResponseEntity<?> update(String id, int tIndex, Transaction txn);

    public ResponseEntity<?> delete(String id, int tIndex);
    
}
