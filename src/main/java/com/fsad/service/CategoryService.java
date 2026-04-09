package com.fsad.service;

import com.fsad.entity.Category;
import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
}