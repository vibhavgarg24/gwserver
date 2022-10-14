package com.ayuvib.gwserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayuvib.gwserver.model.Test;

public interface TestDao extends MongoRepository<Test, String> {

    Test findByKey(int key);

    boolean existsByKey(int key);

}
