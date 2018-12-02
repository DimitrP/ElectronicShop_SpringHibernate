package com.pershyn.electronicshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pershyn.electronicshop.model.Cart;
import com.pershyn.electronicshop.model.Item;
import com.pershyn.electronicshop.model.Product;
import com.pershyn.electronicshop.model.User;
import com.pershyn.electronicshop.service.CartService;
import com.pershyn.electronicshop.service.ProductService;
import com.pershyn.electronicshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class CartController {

    private String cartView = "/cart/index";

    private final ProductService productService;
    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public CartController(ProductService productService, UserService userService, CartService cartService) {
        this.productService = productService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView(cartView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        modelAndView.addObject("items", user.getCart().getItems());
        modelAndView.addObject("cart", user.getCart());

        return modelAndView;
    }

    @RequestMapping(value = {"/cart/delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView deleteItem(@PathVariable(value = "id") Integer id) {
        Authentication authentication;
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user;
        user = userService.getUserByLogin(userName);
        Cart cart = user.getCart();
        Item item = cart.getItem(id);

        Double itemsSum = item.getProduct().getPrice() * item.getCount();
        cart.setSum(cart.getSum() - itemsSum);

        if (cart.getItems().remove(item))
            cartService.updateCart(cart);

        return cart();
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/calculate"})
    public String cartCalculate(@RequestBody Map<String, String> json) {

        Integer id = Integer.valueOf(json.get("id"));
        Boolean isPlus = Boolean.valueOf(json.get("isPlus"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Cart cart = user.getCart();
        Item item = cart.getItem(id);

        if (isPlus) {
            item.setCount(item.getCount() + 1);
            cart.setSum(cart.getSum() + item.getProduct().getPrice());
        } else {
            if (item.getCount() > 1) {
                item.setCount(item.getCount() - 1);
                cart.setSum(cart.getSum() - item.getProduct().getPrice());
            }
        }
        cartService.updateCart(cart);

        Map<String, Object> objects = new HashMap<>();
        objects.put("count", item.getCount());
        objects.put("sum", cart.getSum());

        return getJson(objects);
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/buy"})
    public String buyProduct(@RequestBody String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Product product = productService.getProductById(Integer.valueOf(id), true);

        Cart cart = user.getCart();
        addItemInCart(product, cart);
        cartService.updateCart(cart);

        return getJson("<b>" + product.getTitle() + "</b> been successfully added in your cart!");
    }

    // Метод для преобразования Java объекта в JavaScript объект или строку
    private String getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод добавляет Item в указанную корзину
    private void addItemInCart(Product product , Cart cart) {
        Set<Item> items = cart.getItems();
        boolean flag = true;
        for (Item item : items) {
            if (item.getProduct().equals(product)) {
                item.setCount(item.getCount() + 1);
                cart.setSum(cart.getSum() + product.getPrice());
                flag = false;
            }
        }
        if (flag) {
            Item newItem = new Item();
            newItem.setProduct(product);
            newItem.setCart(cart);
            newItem.setCount(1);
            cart.setSum(cart.getSum() + product.getPrice());
            cart.addItem(newItem);
        }
    }
}
