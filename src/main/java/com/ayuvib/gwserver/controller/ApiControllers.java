package com.ayuvib.gwserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.dao.TestDao;
import com.ayuvib.gwserver.model.Test;
import com.ayuvib.gwserver.service.TestService;


@RestController
public class ApiControllers {

    @Autowired
    private TestService testService;

    @Autowired
    private TestDao testDao;
    
    @GetMapping("/")
    public String welcome() {

        return "Welcome to Greyworm!";
    }

    @GetMapping("/test")
    public List<Test> test() {
        
        return testDao.findAll();
    }

    // @GetMapping("/test")
    // public ResponseEntity<?> test() {
        
    //     return this.testService.test();
    // }

    // @GetMapping("/test/{testKey}")
    // public ResponseEntity<?> testKey(@PathVariable int testKey) {

    //     return this.testService.testKey(testKey);
    // }

    @PostMapping("/test")
    public ResponseEntity<?> add(@RequestBody Test test) {

        return this.testService.add(test);
    }

    @PutMapping("/test")
    public ResponseEntity<?> update(@RequestBody Test test) {

        return this.testService.update(test);
    }

    // @DeleteMapping("test/{testKey}")
    // public ResponseEntity<?> delete(@PathVariable int testKey) {

    //     return this.testService.delete(testKey);
    // }
}
