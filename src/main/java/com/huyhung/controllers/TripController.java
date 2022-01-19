/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.Trip;
import com.huyhung.service.TripService;
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
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping("/admin/trip")
    public String index() {
        return "trip-list";
    }
    
    @GetMapping("/admin/trip/create")
    public String formTrip(Model model) {
        model.addAttribute("trip", new Trip());
        return "trip-form";
    }
    
    @PostMapping("/admin/trip/create")
    public String createTrip(Model model, 
            @ModelAttribute("trip") @Valid Trip trip,
            BindingResult result) {
         return "trip-form";   
    }
}
