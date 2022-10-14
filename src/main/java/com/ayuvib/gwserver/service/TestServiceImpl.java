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
    public ResponseEntity<?> findAll() {
        
        return ResponseEntity.ok(this.testDao.findAll());
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        
        return ResponseEntity.ok(this.testDao.findById(id).get());
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
    public ResponseEntity<?> delete(String id) {
        
        Test del = this.testDao.findById(id).get();
        this.testDao.delete(del);
        return ResponseEntity.ok(del);
    }

    @Override
    public ResponseEntity<?> findByKey(int key) {

        return ResponseEntity.ok(this.testDao.findByKey(key));
    }

    @Override
    public ResponseEntity<?> existsByKey(int key) {
        return ResponseEntity.ok(this.testDao.existsByKey(key));
    }

    @Override
    public ResponseEntity<?> getIdByKey(int key) {
        
        if (this.testDao.existsByKey(key)) {
            Test find = this.testDao.findByKey(key);
            return ResponseEntity.ok(find.getId());
        }

        Test test = new Test(key, 200);
        Test save = this.testDao.save(test);
        return ResponseEntity.ok(save.getId());
    }
}
