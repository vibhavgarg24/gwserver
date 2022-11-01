package com.ayuvib.gwserver.service.user;

import java.util.List;

import com.ayuvib.gwserver.model.User;

public interface UserService {
    
    public List<User> findAll();

    public User findById(String id);

    public String getId(String email);

    public User update(User user);

    public User delete (String id);
}
