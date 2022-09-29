package com.ayuvib.gwserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Test> test() {
        
        return testDao.findAll();
    }

    @Override
    public Test testKey(int testKey) {
        
        return testDao.findById(testKey).get();
    }

    @Override
    public Test add(Test test) {
        
        testDao.save(test);
        return test;
    }

    @Override
    public Test update(Test test) {

        testDao.save(test);
        return test;
    }

    @Override
    public Test delete(int testKey) {
        
        Test t = testDao.findById(testKey).get();
        testDao.delete(t);
        return t;
    }
    
}
