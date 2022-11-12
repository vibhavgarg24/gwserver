package com.ayuvib.gwserver.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuvib.gwserver.dao.CategoryDao;
import com.ayuvib.gwserver.dao.TxnDao;
import com.ayuvib.gwserver.dao.UserDao;
import com.ayuvib.gwserver.exception.DuplicateException;
import com.ayuvib.gwserver.exception.EmptyException;
import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.model.User;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TxnDao txnDao;

    @Override
    public Category add(String userId, String categoryName) {
        
        if (categoryName.trim().equals("")) {
            throw new EmptyException("102", "Category name empty");
        }

        if (this.categoryDao.existsByUserIdAndName(userId, categoryName)) {
            throw new DuplicateException("101", "Duplicate category name");
        }

        Category category = new Category(userId, categoryName);
        Category save = this.categoryDao.save(category);
        return save;
    }

    @Override
    public List<Category> findByUserId(String userId) {

        return this.categoryDao.findByUserId(userId);
    }

    @Override
    public Category findById(String catId) {

        return this.categoryDao.findById(catId).get();
    }

    @Override
    public Category update(Category category) {

        Category save = this.categoryDao.save(category);
        return save;
    }

    @Override
    public Category delete(String catId) {

        // delete all txns of this category
        this.txnDao.deleteAllByCatId(catId);

        Category del = findById(catId);

        // sub cat sum from user total
        User user = this.userDao.findById(del.getUserId()).get();
        user.setTotalSum(user.getTotalSum() - del.getSum());
        this.userDao.save(user);
        
        this.categoryDao.deleteById(catId);
        return del;
    }
    
}