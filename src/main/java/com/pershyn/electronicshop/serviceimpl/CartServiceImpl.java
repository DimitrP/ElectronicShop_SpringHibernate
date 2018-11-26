package com.pershyn.electronicshop.serviceimpl;

import com.pershyn.electronicshop.dao.CartDAO;
import com.pershyn.electronicshop.model.Cart;
import com.pershyn.electronicshop.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    @Transactional
    public void updateCart(Cart cart) {
        this.cartDAO.updateCart(cart);
    }
}
