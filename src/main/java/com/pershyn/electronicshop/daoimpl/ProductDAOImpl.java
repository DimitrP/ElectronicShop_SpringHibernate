package com.pershyn.electronicshop.daoimpl;

import com.pershyn.electronicshop.dao.ProductDAO;
import com.pershyn.electronicshop.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    public ProductDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }



    @Override
    public Product getProductByName(String name) {
        return (Product) getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }

    @Override
    public Product getProductByName(String name, Boolean active) {
        return (Product) getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .add(Restrictions.eq("active", active))
                .uniqueResult();
    }

    @Override
    public Product getProductById(Integer id) {
        return (Product) getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public Product getProductById(Integer id, Boolean active) {
        return (Product) getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("active", active))
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getAllProducts() {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .list();
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getAllProducts(Boolean active) {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("active", active))
                .list();
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProductsByCategory(Integer categoryId) {
        return getProductsByCategory(null, categoryId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProductsByCategory(Integer count, Integer categoryId) {
        List<Product> Products;

        if (count != null) {
            Products = getSession()
                    .createCriteria(Product.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .setMaxResults(count)
                    .list();
        } else {
            Products = getSession()
                    .createCriteria(Product.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .list();
        }
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProductsByCategory(Integer categoryId, Boolean active) {
        return getProductsByCategory(null, categoryId, active);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProductsByCategory(Integer count, Integer categoryId, Boolean active) {
        List<Product> Products;

        if (count != null) {
            Products = getSession()
                    .createCriteria(Product.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .add(Restrictions.eq("active", active))
                    .setMaxResults(count)
                    .list();
        } else {
            Products = getSession()
                    .createCriteria(Product.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .add(Restrictions.eq("active", active))
                    .list();
        }
        return new HashSet<>(Products);
    }

    @Override
    public void addProduct(Product Product) {
        getSession().save(Product);
    }

    @Override
    public void updateProduct(Product Product) {
        getSession().update(Product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product Product = (Product)getSession().load(Product.class, id);
        if(Product!=null){
            getSession().delete(Product);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProducts(Integer count) {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .setMaxResults(count)
                .list();
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getProducts(Integer count, Boolean active) {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("active", active))
                .setMaxResults(count)
                .list();
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getLastAddedProducts(Integer count) {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .addOrder(Order.desc("id"))
                .setMaxResults(count)
                .list();
        return new HashSet<>(Products);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Product> getLastAddedProducts(Integer count, Boolean active) {
        List<Product> Products = getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("active", active))
                .addOrder(Order.desc("id"))
                .setMaxResults(count)
                .list();
        return new HashSet<>(Products);
    }
}
