package com.ayuvib.gwserver.service.category;

import com.ayuvib.gwserver.model.Category;

public interface CategoryService {

    public Category add(String id, Category category);

    public Category findByName(String id, String name);

    public Category findByIndex(String id, int index);

    public Category update(String id, int cIndex, Category category);

    public Category delete(String id, int cIndex);
}
