package com.pershyn.electronicshop.dao;
import com.pershyn.electronicshop.model.Product;

import java.util.Set;

public interface ProductDAO {

    public Product getProductByName(String name);

    public Product getProductByName(String name, Boolean active);

    public Product getProductById(Integer id);

    public Product getProductById(Integer id, Boolean active);

    public Set<Product> getAllProducts();

    public Set<Product> getAllProducts(Boolean active);

    public Set<Product> getProducts(Integer count);

    public Set<Product> getProducts(Integer count, Boolean active);

    public Set<Product> getLastAddedProducts(Integer count);

    public Set<Product> getLastAddedProducts(Integer count, Boolean active);

    public Set<Product> getProductsByCategory(Integer categoryId);

    public Set<Product> getProductsByCategory(Integer categoryId, Boolean active);

    public Set<Product> getProductsByCategory(Integer count, Integer categoryId);

    public Set<Product> getProductsByCategory(Integer count, Integer categoryId, Boolean active);

    void addProduct(Product Product);

    void updateProduct(Product Product);

    void deleteProduct(Integer id);
}
