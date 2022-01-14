/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TIM
 */
@Controller
@Transactional
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/admin/order")
    public String index() {
        return "order-list";
    }

    @RequestMapping("/admin/order/create")
    public String orderCreate() {
        return "order-form";
    }
}
