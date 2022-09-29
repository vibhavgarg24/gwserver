package com.ayuvib.gwserver.service;

import java.util.List;

import com.ayuvib.gwserver.model.Test;

public interface TestService {

    public List<Test> test();

    public Test testKey(int testKey);

    public Test add(Test test);

    public Test update(Test test);

    public Test delete(int testKey);

}
