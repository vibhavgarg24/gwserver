package com.ayuvib.gwserver.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(){}

    @Override
    public ResponseEntity<?> findAll() {
        
        return ResponseEntity.ok(this.userDao.findAll());
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        
        return ResponseEntity.ok(this.userDao.findById(id).get());
    }

    @Override
    public ResponseEntity<?> getId(String email) {
        
        if (this.userDao.existsByEmail(email)) {
            User find = this.userDao.findByEmail(email);
            return ResponseEntity.ok(find.getId());
        }

        User user = new User(email);
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save.getId());
    }

    @Override
    public ResponseEntity<?> update(User user) {
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        
        User del = this.userDao.findById(id).get();
        this.userDao.deleteById(id);
        return ResponseEntity.ok(del);
    }
}
