package com.ayuvib.gwserver.service.transaction;

import com.ayuvib.gwserver.model.Transaction;

public interface TransactionService {

    public Transaction add(String id, int cIndex, Transaction txn);

    public Transaction find(String id, int cIndex, int tIndex);

    public Transaction update(String id, int oldCIndex, int oldTIndex, int newCIndex, Transaction txn);

    public Transaction delete(String id, int cIndex, int tIndex);
}
