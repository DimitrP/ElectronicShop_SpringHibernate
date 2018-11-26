package com.pershyn.electronicshop.service;

import com.pershyn.electronicshop.model.Category;

import java.util.Set;

public interface CategoryService {

    Category getCategoryById(Integer id);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);

    Set<Category> getAllCategories();
}
