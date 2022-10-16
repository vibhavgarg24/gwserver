package com.ayuvib.gwserver.service.category;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Category;

public interface CategoryService {

    public ResponseEntity<?> add(String id, String name);

    public ResponseEntity<?> find(String id, String name);

    public ResponseEntity<?> update(String id, int index, Category category);

    public ResponseEntity<?> delete(String id, int index);
}
