package com.fsad.controller;

import com.fsad.entity.Category;
import com.fsad.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }
}