package com.pershyn.electronicshop.controller;

import com.pershyn.electronicshop.service.NewsService;
import com.pershyn.electronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private String indexView = "/index";

    private final ProductService productService;
    private final NewsService newsService;

    @Autowired
    public IndexController(ProductService productService, NewsService newsService) {
        this.productService = productService;
        this.newsService = newsService;
    }

    @RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView(indexView);
        modelAndView.addObject("newProducts", productService.getLastAddedProducts(4, true));
        modelAndView.addObject("catalogProducts", productService.getProducts(8, true));
        modelAndView.addObject("carouselItems", productService.getProducts(3));
        modelAndView.addObject("listNews", newsService.getLastAddedNews(3));
        return modelAndView;
    }
}
