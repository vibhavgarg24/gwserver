package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.model.User;
import com.ayuvib.gwserver.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        
        return this.userService.findAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        return this.userService.findById(id);
    }

    // Used for adding new User as well
    @GetMapping("/getId/{email}")
    public ResponseEntity<?> getId(@PathVariable String email) {

        return this.userService.getId(email);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {

        return this.userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        return this.userService.delete(id);
    }
}
