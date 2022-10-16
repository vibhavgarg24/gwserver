package com.ayuvib.gwserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayuvib.gwserver.model.User;

public interface UserDao extends MongoRepository<User, String> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
