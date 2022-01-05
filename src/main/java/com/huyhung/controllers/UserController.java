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
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/sign-in")
    public String index() {
        return "sign-in";
    }
    
    @RequestMapping("/admin/user")
    public String userList() {
        return "user-list";
    }
    
    @GetMapping("/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        System.out.println(this.userService.getRoleList());
        model.addAttribute("roleList", this.userService.getRoleList());
        return "user-form";
    }
    
    @PostMapping("/admin/user/create")
    public String createUser(Model model,
            @ModelAttribute("user") @Valid User user,
            BindingResult result) {
        if (result.hasErrors())
            return "user-form";
          
        
        if (this.userService.createUser(user) == true)
            return "redirect:/admin/user";
        
        return "user-form";
    }
    
    @RequestMapping("/admin/user/update/{userId}")
    public String updateUser() {
        return "user-form";
    }
    
}
