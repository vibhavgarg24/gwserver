package com.ayuvib.gwserver.service.transaction;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Transaction;

public interface TransactionService {

    public ResponseEntity<?> add(String id, int cIndex, Transaction txn);

    public ResponseEntity<?> find(String id, int cIndex, int tIndex);

    public ResponseEntity<?> update(String id, int oldCIndex, int oldTIndex, int newCIndex, Transaction txn);

    public ResponseEntity<?> delete(String id, int cIndex, int tIndex);
    
}
