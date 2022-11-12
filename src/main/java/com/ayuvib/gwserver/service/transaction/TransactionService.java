package com.ayuvib.gwserver.service.transaction;

import java.util.List;

import com.ayuvib.gwserver.model.Transaction;

public interface TransactionService {

    public Transaction add(Transaction txn);

    public Transaction findById(String txnId);

    public List<Transaction> findByUserId(String userId);

    public List<Transaction> findByCatId(String catId);

    public Transaction update(Transaction txn);

    public Transaction delete(String txnId);
}
