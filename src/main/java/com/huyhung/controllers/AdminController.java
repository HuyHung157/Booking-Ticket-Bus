/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TIM
 */
public class AdminController {

    @RequestMapping("/admin")
    public String index() {
        return "admin";
    }
}
