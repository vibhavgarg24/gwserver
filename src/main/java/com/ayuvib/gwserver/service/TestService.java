package com.ayuvib.gwserver.service;

import java.util.List;

import com.ayuvib.gwserver.model.Test;

public interface TestService {

    public List<Test> test();
    public Test testKey(int testKey);
}
