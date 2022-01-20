/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.User;
import com.huyhung.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TIM
 */
@Controller
@Transactional
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    @RequestMapping("/admin/user")
    public String userList(Model model,
    @RequestParam(value="kw", required = false) String userName) {
        model.addAttribute("mode", "User");
        model.addAttribute("userList", this.userDetailsService.getListUser(userName));
        return "user-list";
    }

    @GetMapping("/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("mode", "User");
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.userDetailsService.getRoleList());
        return "user-form";
    }

    @PostMapping("/admin/user/create")
    public String createUser(Model model,
            @ModelAttribute("user") @Valid User user,
            BindingResult result) {
        String errMsg = "";
        if (result.hasErrors()) {
            return "user-form";
        }

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.createUser(user)) {
                return "redirect:/admin/user/";
            } else {
                errMsg = "Hệ thống đã xảy ra lỗi! Vui lòng thử lại sau!";
            }
        } else {
            errMsg = "Mật khẩu không khớp";
        }

        model.addAttribute("errMsg", errMsg);
        model.addAttribute("roleList", this.userDetailsService.getRoleList());

        return "user-form";
    }

    @RequestMapping("/admin/user/update/{userId}")
    public String updateUser() {
        return "user-form";
    }

    @RequestMapping("/admin/employee")
    public String employeeList(Model model,
    @RequestParam(value="kw", required = false) String userName) {
        model.addAttribute("mode", "Employee");
        model.addAttribute("userList", this.userDetailsService.getListUser(userName));
        return "employee-list";
    }

    @RequestMapping("/admin/employee/create")
    public String createEmployee(Model model) {
        model.addAttribute("mode", "Employee");
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.userDetailsService.getRoleList());
        return "employee-form";
    }

    @RequestMapping("/admin/employee/update/{employeeId}")
    public String updateEmployee(Model model) {
        model.addAttribute("mode", "Employee");
        return "employee-form";
    }

//Profile    
    @RequestMapping("/admin/profile")
    public String editProfile(Model model) {
        model.addAttribute("mode", "Profile");
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.userDetailsService.getRoleList());
        return "profile";
    }

}
