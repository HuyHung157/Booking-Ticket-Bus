/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.service.TripService;
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
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping("/admin/trip")
    public String index() {
        return "trip-list";
    }

    @RequestMapping("/admin/trip/create")
    public String tripCreate() {
        return "trip-form";
    }
}
