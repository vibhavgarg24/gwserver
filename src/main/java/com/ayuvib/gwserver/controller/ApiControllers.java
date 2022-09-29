package com.ayuvib.gwserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Test testKey(@PathVariable int testKey) {

        return this.testService.testKey(testKey);
    }

    @PostMapping("/test")
    public Test add(@RequestBody Test test) {

        return this.testService.add(test);
    }

    @PutMapping("/test")
    public Test update(@RequestBody Test test) {

        return this.testService.update(test);
    }

    @DeleteMapping("test/{testKey}")
    public Test delete(@PathVariable int testKey) {

        return this.testService.delete(testKey);
    }
}
