package com.pershyn.electronicshop.admincontroller;

import com.pershyn.electronicshop.model.Product;
import com.pershyn.electronicshop.service.CategoryService;
import com.pershyn.electronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "adminProductController")
@RequestMapping("/admin/product")
public class ProductController {

    private String addProductView = "/admin/product/addProduct";
    private String indexProductView = "/admin/product/index";
    private String updateProductView = "/admin/product/updateProduct";

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(indexProductView);
        List<Product> products = new ArrayList<>(productService.getAllProducts());
        products.sort(Comparator.comparing(Product::getProduct_id));
        modelAndView.addObject("product", products);
        return modelAndView;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView(addProductView);
        return getProductModelAndView(modelAndView, product);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute Product product,
                                ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("success", "Product has been added: " + product);
        return new ModelAndView("redirect: " + indexProductView);
    }

    @RequestMapping(value = {"/updateProduct/{id}" , "/updateProduct"}, method = RequestMethod.GET)
    public ModelAndView updateProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateProductView);
        Product product = productService.getProductById(id);
        if (product.getProduct_id() == null) {
            redirectAttrs.addFlashAttribute("error", "No selected product");
            return new ModelAndView("redirect:" + indexProductView);
        }
        product = productService.getProductById(product.getProduct_id());
        modelAndView.addObject("product", product);
        return getProductModelAndView(modelAndView, product);
    }


//    @RequestMapping(value = {"/updateProduct/{id}", "/updateProduct"}, method = RequestMethod.GET)
//    public ModelAndView updateProduct(Product product, RedirectAttributes redirectAttrs) {
//        ModelAndView modelAndView = new ModelAndView(updateProductView);
//        if (product.getProduct_id() == null) {
//            redirectAttrs.addFlashAttribute("error", "No selected product");
//            return new ModelAndView("redirect:" + indexProductView);
//        }
//        product = productService.getProductById(product.getProduct_id());
//        modelAndView.addObject("product", product);
//        return getProductModelAndView(modelAndView, product);
//    }






    @RequestMapping(value = {"/updateProduct"}, method = RequestMethod.POST)
    public ModelAndView updateProduct(@Valid @ModelAttribute Product product,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        productService.updateProduct(product);
        redirectAttrs.addFlashAttribute("success", "Product has been updated: " + product);
        return new ModelAndView("redirect:" + indexProductView);
    }

    @RequestMapping(value = {"/deleteProduct/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        Product product = productService.getProductById(id);
        productService.deleteProduct(id);
        redirectAttrs.addFlashAttribute("success", "Product has been deleted: " + product);
        return "redirect:" + indexProductView;
    }

    private ModelAndView getProductModelAndView(ModelAndView modelAndView, Product product) {
        modelAndView.addObject("currentCategory", product.getCategory());
        modelAndView.addObject("allCategories", categoryService.getAllCategories());
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
