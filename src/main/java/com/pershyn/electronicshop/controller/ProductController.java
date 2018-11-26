package com.pershyn.electronicshop.controller;

import com.pershyn.electronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private String detailView = "/product/detail";
    private String categoryView = "/product/category";

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = {"/product/detail/{id}"}, method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView(detailView);
        modelAndView.addObject("product", productService.getProductById(id, true));

        return modelAndView;
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public ModelAndView category(@PathVariable(value = "id") Integer categoryId) {
        // Сколько товаров выводить в каталоге
        Integer goodsCount = 12;

        ModelAndView modelAndView = new ModelAndView(categoryView);
        modelAndView.addObject("category", categoryId);
        modelAndView.addObject("catalogProducts", productService.getProductsByCategory(goodsCount, categoryId, true));

        return modelAndView;
    }
}
