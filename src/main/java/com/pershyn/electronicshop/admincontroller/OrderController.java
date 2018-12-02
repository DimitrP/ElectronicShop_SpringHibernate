package com.pershyn.electronicshop.admincontroller;

import com.pershyn.electronicshop.model.Order;
import com.pershyn.electronicshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "adminOrderController")
@RequestMapping(value = "/admin/order")
public class OrderController {

    private String indexOrderView = "/admin/order/index";
    private String updateOrderView = "/admin/order/updateOrder";

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(indexOrderView);
        List<Order> order = new ArrayList<>(orderService.getAllOrders());
        order.sort(Comparator.comparing(Order::getId));
        modelAndView.addObject("orders", order);
        return modelAndView;
    }

    @RequestMapping(value = {"/updateOrder/{id}", "/updateOrder"}, method = RequestMethod.GET)
    public ModelAndView updateOrder(Order order, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateOrderView);
        order = orderService.getOrderById(order.getId());
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @RequestMapping(value = {"/updateOrder"}, method = RequestMethod.POST)
    public ModelAndView updateOrder(@ModelAttribute Order order,
                                    final ModelAndView modelAndView,
                                    RedirectAttributes redirectAttrs) {

        System.out.println(order.getStatus()+ "!!!!!!!!!!!!!!!!!!!");

        orderService.updateOrder(order);
        redirectAttrs.addFlashAttribute("success", "Order has been updated: " + order);
        return new ModelAndView("redirect:" + indexOrderView);
    }
}
