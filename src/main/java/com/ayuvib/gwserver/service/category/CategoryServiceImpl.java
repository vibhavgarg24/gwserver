package com.ayuvib.gwserver.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.model.User;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<?> add(String id, String name) {
        
        User user = this.userDao.findById(id).get();
        if (name.trim().equals("")) {
            return ResponseEntity.ok(user);
        }

        List<Category> list = user.getCategories();
        for (Category cat: list) {
            if (cat.getName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
                return ResponseEntity.ok(user);
            }
        }
        
        list.add(new Category(name));
        user.setCategories(list);
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }



    @Override
    public ResponseEntity<?> find(String id, String name) {
        
        List<Category> list = this.userDao.findById(id).get().getCategories();
        for (Category cat: list) {
            if (cat.getName().equals(name)) {
                return ResponseEntity.ok(cat);
            }
        }

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<?> update(String id, int index, Category category) {

        User user = this.userDao.findById(id).get();
        user.getCategories().set(index, category);
        
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> delete(String id, int index) {
        
        User user = this.userDao.findById(id).get();
        user.getCategories().remove(index);
        
        User save = this.userDao.save(user);
        return ResponseEntity.ok(save);
    }
    
}
