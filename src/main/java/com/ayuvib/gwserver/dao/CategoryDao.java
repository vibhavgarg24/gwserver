package com.ayuvib.gwserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayuvib.gwserver.model.Category;

public interface CategoryDao extends MongoRepository<Category, String> {

    boolean existsByUserIdAndName(String userId, String name);

    List<Category> findByUserId(String userId);

    Optional<Category> findById(String id);
    
}
