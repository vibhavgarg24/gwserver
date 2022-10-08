package com.ayuvib.gwserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.TestDao;
import com.ayuvib.gwserver.model.Test;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    public TestServiceImpl() {
    }

    @Override
    public ResponseEntity<?> test() {
        
        return ResponseEntity.ok(this.testDao.findAll());
    }

    @Override
    public ResponseEntity<?> testKey(int testKey) {
        
        return ResponseEntity.ok(this.testDao.findById(testKey).get());
    }

    @Override
    public ResponseEntity<?> add(Test test) {
        
        Test save = this.testDao.save(test);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> update(Test test) {

        Test save = this.testDao.save(test);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> delete(int testKey) {
        
        Test del = this.testDao.findById(testKey).get();
        this.testDao.delete(del);
        return ResponseEntity.ok(del);
    }
    
}
