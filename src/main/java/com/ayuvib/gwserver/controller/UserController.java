package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayuvib.gwserver.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

}
