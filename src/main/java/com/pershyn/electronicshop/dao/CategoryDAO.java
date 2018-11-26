package com.pershyn.electronicshop.dao;
import com.pershyn.electronicshop.model.Category;

import java.util.Set;

public interface CategoryDAO {

    Category getCategoryById(Integer id);

    void updateCategory(Category category);

    void addCategory(Category category);

    void deleteCategoryById(Integer id);

    Set<Category> getAllCategories();
}
