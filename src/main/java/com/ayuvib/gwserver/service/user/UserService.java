package com.ayuvib.gwserver.service.user;

import org.springframework.http.ResponseEntity;

import com.ayuvib.gwserver.model.User;

public interface UserService {
    
    public ResponseEntity<?> findAll();

    public ResponseEntity<?> findById(String id);

    public ResponseEntity<?> getId(String email);

    public ResponseEntity<?> update(User user);

    public ResponseEntity<?> delete (String id);
}
