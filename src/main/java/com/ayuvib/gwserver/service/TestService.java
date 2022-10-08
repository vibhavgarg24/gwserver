package com.ayuvib.gwserver.service;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.Test;

public interface TestService {

    public ResponseEntity<?> test();

    public ResponseEntity<?> testKey(int testKey);

    public ResponseEntity<?> add(Test test);

    public ResponseEntity<?> update(Test test);

    public ResponseEntity<?> delete(int testKey);

}
