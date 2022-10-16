package com.ayuvib.gwserver.service.test;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Test;

public interface TestService {

    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById(String id);

    public ResponseEntity<?> add(Test test);

    public ResponseEntity<?> update(Test test);

    public ResponseEntity<?> delete(String id);

    public ResponseEntity<?> findByKey(int key);

    public ResponseEntity<?> existsByKey(int key);

    public ResponseEntity<?> getIdByKey(int key);
}
