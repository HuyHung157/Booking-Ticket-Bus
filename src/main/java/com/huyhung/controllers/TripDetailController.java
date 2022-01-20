/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.TripDetail;
import com.huyhung.service.TripDetailService;
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
public class TripDetailController {
    @Autowired
    private TripDetailService tripDetailService;

    @RequestMapping("/admin/trip-detail")
    public String index() {
        return "trip-detail-list";
    }
    
    @GetMapping("/admin/trip-detail/create")
    public String formTrip(Model model) {
        model.addAttribute("trip-detail", new TripDetail());
        return "trip-detail-form";
    }
    
    @PostMapping("/admin/trip-detail/create")
    public String createTrip(Model model, 
            @ModelAttribute("trip-detail") @Valid TripDetail tripDetail,
            BindingResult result) {
         return "trip-detail-form";   
    }
}
