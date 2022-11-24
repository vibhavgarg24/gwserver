package com.ayuvib.gwserver.service.category;

import java.util.List;

import com.ayuvib.gwserver.model.Category;

public interface CategoryService {

    public Category add(String userId, String categoryName);

    public List<Category> findByUserId(String userId);

    public Category findById(String catId);

    public Category update(Category category);

    public Category delete(String catId);

    public Category reset(String catId);
}
