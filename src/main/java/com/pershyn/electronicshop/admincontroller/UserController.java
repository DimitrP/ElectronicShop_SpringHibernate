package com.pershyn.electronicshop.admincontroller;

import com.pershyn.electronicshop.model.Cart;
import com.pershyn.electronicshop.model.Role;
import com.pershyn.electronicshop.model.User;
import com.pershyn.electronicshop.service.RoleService;
import com.pershyn.electronicshop.service.UserService;
import com.pershyn.electronicshop.validation.UserFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

    private String userIndexView = "/admin/user/index";
    private String updateUserView = "/admin/user/updateUser";
    private String addUserView = "/admin/user/addUser";

    private final UserService userService;
    private final RoleService roleService;
    private final UserFormValidation userFormValidation;

    @Autowired
    public UserController(UserService userService, RoleService roleService, UserFormValidation userFormValidation) {
        this.userService = userService;
        this.roleService = roleService;
        this.userFormValidation = userFormValidation;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(userIndexView);
        List<User> users = new ArrayList<>(userService.getAllUsers());
        // Отсортируем по ID
        users.sort(Comparator.comparing(User::getId));
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public ModelAndView addUser(User user) {
        ModelAndView modelAndView = new ModelAndView(addUserView);
        return getUserModelAndView(modelAndView, user);
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute User user,
                                final BindingResult result,
                                ModelAndView modelAndView,
                                RedirectAttributes redirectAttrs) {
        if (user.getLogin() == null &&
                userService.getUserByLogin(user.getLogin()) != null) {
            result.rejectValue("login", "exist.user.login");
        }
        if (result.hasErrors()) {
            return getUserModelAndView(modelAndView, user);
        }
        user.setCart(new Cart());
        //if admin doesn't select role
        if (user.getRoles() == null) {
            Set<Role> role = new HashSet<>();
            role.add(roleService.getRoleByName("ROLE_USER"));
            user.setRoles(role);
        }
        userService.addUser(user);
        redirectAttrs.addFlashAttribute("success", "User added: " + user);
        return new ModelAndView("redirect:" + userIndexView);
    }

    @RequestMapping(value = {"/updateUser/{id}", "/updateUser"}, method = RequestMethod.GET)
    public ModelAndView updateUser(User user, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView(updateUserView);
        if (user.getId() == null) {
            redirectAttrs.addFlashAttribute("error", "No selected user");
            return new ModelAndView("redirect:" + userIndexView);
        }
        user = userService.getUserById(user.getId());
        modelAndView.addObject("user", user);
        return getUserModelAndView(modelAndView, user);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute User user,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return getUserModelAndView(modelAndView, user);
        }
        userService.updateUser(user);
        redirectAttrs.addFlashAttribute("success", "User updated: " + user);
        return new ModelAndView("redirect:" + userIndexView);
    }

    @RequestMapping(value = {"/deleteUser/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
        User user = userService.getUserById(id);
        userService.deleteUserById(id);
        redirectAttrs.addFlashAttribute("success", "Delete user: " + user);
        return "redirect:" + userIndexView;
    }

    private ModelAndView getUserModelAndView(ModelAndView modelAndView, User user) {
        modelAndView.addObject("currentRoles", user.getRoles());
        modelAndView.addObject("allRoles", roleService.getAllRoles());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @InitBinder("user")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidation);
    }
}
