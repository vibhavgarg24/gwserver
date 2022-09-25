package com.ayuvib.gwserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.model.Test;

@Service
public class TestServiceImpl implements TestService {

    List<Test> list;

    public TestServiceImpl() {
        list = new ArrayList<>();
        list.add(new Test (1, 37));
        list.add(new Test (2, 209));
    }

    @Override
    public List<Test> test() {
        
        return list;
    }

    @Override
    public Test testKey(int testKey) {
        
        Test ans = null;

        for (Test t: list) {
            if (t.getKey() == testKey) {
                ans = t;
                break;
            }
        }

        return ans;
    }
    
}
