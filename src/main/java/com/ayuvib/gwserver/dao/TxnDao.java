package com.ayuvib.gwserver.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayuvib.gwserver.model.Transaction;

public interface TxnDao extends MongoRepository<Transaction, String> {

    List<Transaction> findByUserId(String userId);

    List<Transaction> findByCatId(String catId);

    void deleteAllByCatId(String catId);
    
}
