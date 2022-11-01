package com.ayuvib.gwserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/add/{userId}/{categoryName}")
    public ResponseEntity<Category> add(@PathVariable String userId, @PathVariable String categoryName) {

        Category category = new Category(categoryName);
        Category addedCategory = this.categoryService.add(userId, category);
        return new ResponseEntity<Category>(addedCategory, HttpStatus.OK);
    }

    @GetMapping("/find/{userId}/{categoryName}")
    public ResponseEntity<Category> find(@PathVariable String userId, @PathVariable String categoryName) {

        Category category = this.categoryService.find(userId, categoryName);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}/{cIndex}")
    public ResponseEntity<Category> update(@PathVariable String userId, @PathVariable int cIndex, @RequestBody Category category) {

        Category updatedCategory =  this.categoryService.update(userId, cIndex, category);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{userId}/{cIndex}")
    public ResponseEntity<Category> delete(@PathVariable String userId, @PathVariable int cIndex) {

        Category deletedCategory =  this.categoryService.delete(userId, cIndex);
        return new ResponseEntity<Category>(deletedCategory, HttpStatus.OK);
    }
}
