package com.pershyn.electronicshop.serviceimpl;

import com.pershyn.electronicshop.dao.CategoryDAO;
import com.pershyn.electronicshop.model.Category;
import com.pershyn.electronicshop.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) {
        this.categoryDAO.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryDAO.updateCategory(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryDAO.getCategoryById(id);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        this.categoryDAO.deleteCategoryById(id);
    }

    @Override
    public Set<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
