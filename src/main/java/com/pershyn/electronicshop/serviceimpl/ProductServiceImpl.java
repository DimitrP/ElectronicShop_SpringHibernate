package com.pershyn.electronicshop.serviceimpl;

import com.pershyn.electronicshop.dao.ProductDAO;
import com.pershyn.electronicshop.model.Product;
import com.pershyn.electronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO ProductDao;

    @Autowired
    public ProductServiceImpl(ProductDAO ProductDao) {
        this.ProductDao = ProductDao;
    }

    @Override
    @Transactional
    public Product getProductByName(String name) {
        return ProductDao.getProductByName(name);
    }

    @Override
    @Transactional
    public Product getProductByName(String name, Boolean active) {
        return ProductDao.getProductByName(name, active);
    }

    @Override
    @Transactional
    public Product getProductById(Integer id) {
        return ProductDao.getProductById(id);
    }

    @Override
    @Transactional
    public Product getProductById(Integer id, Boolean active) {
        return ProductDao.getProductById(id, active);
    }

    @Override
    @Transactional
    public Set<Product> getAllProducts() {
        return ProductDao.getAllProducts();
    }

    @Override
    @Transactional
    public Set<Product> getAllProducts(Boolean active) {
        return ProductDao.getAllProducts(active);
    }

    @Override
    @Transactional
    public Set<Product> getProducts(Integer count) {
        return ProductDao.getProducts(count);
    }

    @Override
    @Transactional
    public Set<Product> getProducts(Integer count, Boolean active) {
        return ProductDao.getProducts(count, active);
    }

    @Override
    @Transactional
    public Set<Product> getLastAddedProducts(Integer count) {
        return ProductDao.getLastAddedProducts(count);
    }

    @Override
    @Transactional
    public Set<Product> getLastAddedProducts(Integer count, Boolean active) {
        return ProductDao.getLastAddedProducts(count, active);
    }

    @Override
    @Transactional
    public Set<Product> getProductsByCategory(Integer categoryId) {
        return ProductDao.getProductsByCategory(categoryId);
    }

    @Override
    @Transactional
    public Set<Product> getProductsByCategory(Integer categoryId, Boolean active) {
        return ProductDao.getProductsByCategory(categoryId, active);
    }

    @Override
    @Transactional
    public Set<Product> getProductsByCategory(Integer count, Integer categoryId) {
        return ProductDao.getProductsByCategory(count, categoryId);
    }

    @Override
    @Transactional
    public Set<Product> getProductsByCategory(Integer count, Integer categoryId, Boolean active) {
        return ProductDao.getProductsByCategory(count, categoryId, active);
    }

    @Override
    @Transactional
    public void addProduct(Product Product) {
        this.ProductDao.addProduct(Product);
    }

    @Override
    @Transactional
    public void updateProduct(Product Product) {
        this.ProductDao.updateProduct(Product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        this.ProductDao.deleteProduct(id);
    }
}
