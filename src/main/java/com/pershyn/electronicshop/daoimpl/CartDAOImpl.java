package com.pershyn.electronicshop.daoimpl;

import com.pershyn.electronicshop.dao.CartDAO;
import com.pershyn.electronicshop.model.Cart;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CartDAOImpl extends AbstractDAO implements CartDAO {

    public CartDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void updateCart(Cart cart) {
        getSession().update(cart);
    }
}
