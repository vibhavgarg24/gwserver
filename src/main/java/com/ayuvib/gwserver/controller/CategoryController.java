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

import com.ayuvib.gwserver.model.Category;
import com.ayuvib.gwserver.service.category.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController() {
    }

    @GetMapping("/add/{userId}/{categoryName}")
    public ResponseEntity<?> add(@PathVariable String userId, @PathVariable String categoryName) {

        return this.categoryService.add(userId, categoryName);
    }

    @GetMapping("/find/{userId}/{categoryName}")
    public ResponseEntity<?> find(@PathVariable String userId, @PathVariable String categoryName) {

        return this.categoryService.find(userId, categoryName);
    }

    @PutMapping("/update/{userId}/{cIndex}")
    public ResponseEntity<?> update(@PathVariable String userId, @PathVariable int cIndex, @RequestBody Category category) {

        return this.categoryService.update(userId, cIndex, category);
    }
    
    @DeleteMapping("/delete/{userId}/{cIndex}")
    public ResponseEntity<?> delet(@PathVariable String userId, @PathVariable int cIndex) {

        return this.categoryService.delete(userId, cIndex);
    }
}
