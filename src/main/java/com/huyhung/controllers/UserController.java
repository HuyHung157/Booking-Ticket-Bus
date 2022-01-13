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
    public String userList() {
        return "user-list";
    }
    
    @RequestMapping("/admin/employee")
    public String employeeList() {
        return "employee-list";
    }
    
    @RequestMapping("/admin/employee/create")
    public String employeeCreate() {
        return "employee-form";
    }
    
    @GetMapping("/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        System.out.println(this.userDetailsService.getRoleList());
        model.addAttribute("roleList", this.userDetailsService.getRoleList());
        return "user-form";
    }
    
    @PostMapping("/admin/user/create")
    public String createUser(Model model,
            @ModelAttribute("user") @Valid User user,
            BindingResult result) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.createUser(user))
                return "redirect:/admin/user/";
            else
                errMsg = "He thong dang co loi! Vui long quay lai sau!";
        } else
            errMsg = "Mat khau KHONG khop!";
        
        
        model.addAttribute("errMsg", errMsg);
        
        return "user-form";
    }
    
    @RequestMapping("/admin/user/update/{userId}")
    public String updateUser() {
        return "user-form";
    }
    
}
