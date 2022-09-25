package com.ayuvib.gwserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.model.Test;
import com.ayuvib.gwserver.service.TestService;


@RestController
public class ApiControllers {

    @Autowired
    private TestService testService;
    
    @GetMapping("/")
    public String welcome() {

        return "Welcome to greyworm!";
    }

    @GetMapping("/test")
    public List<Test> test() {
        
        return this.testService.test();
    }

    @GetMapping("/test/{testKey}")
    public Test testId(@PathVariable int testKey) {

        return this.testService.testKey(testKey);
    }
}
