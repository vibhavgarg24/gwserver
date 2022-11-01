package com.ayuvib.gwserver.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.exception.DuplicateException;
import com.ayuvib.gwserver.exception.EmptyException;
import com.ayuvib.gwserver.exception.InvalidInputException;
import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.model.User;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private UserDao userDao;

    @Override
    public Category add(String id, Category category) {
        
        User user = this.userDao.findById(id).get();
        if (category.getName().trim().equals("")) {
            throw new EmptyException("102", "Category name empty");
        }

        // duplicate category name
        if (find(id, category.getName().trim().toLowerCase()) != null) {
            throw new DuplicateException("101", "Duplicate category name");
        }
        
        List<Category> list = this.userDao.findById(id).get().getCategories();
        list.add(category);
        user.setCategories(list);
        user.setTotalSum(user.getTotalSum() + category.getSum());

        this.userDao.save(user);
        return category;
    }

    @Override
    public Category find(String id, String name) {
        
        List<Category> list = this.userDao.findById(id).get().getCategories();
        for (Category cat: list) {
            if (cat.getName().toLowerCase().equals(name)) {
                return cat;
            }
        }

        // change to not found exc
        return null;
    }

    @Override
    public Category update(String id, int cIndex, Category category) {

        Category deletedCategory = delete(id, cIndex);
        try {
            add(id, category);
        } catch (Exception e) {
            add(id, deletedCategory);
            throw e;
        }

        return category;
    }

    @Override
    public Category delete(String id, int cIndex) {
        
        User user = this.userDao.findById(id).get();
        if (cIndex < 0 || cIndex >= user.getCategories().size()) {
            throw new InvalidInputException("103", "Invalid category index");
        }
        
        Category category = user.getCategories().remove(cIndex);
        user.setTotalSum(user.getTotalSum() - category.getSum());
        this.userDao.save(user);

        return category;
    }
    
}
