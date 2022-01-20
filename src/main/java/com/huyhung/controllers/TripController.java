/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.Trip;
import com.huyhung.service.LocationService;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TIM
 */
@Controller
@Transactional
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private LocationService locationService;

    @RequestMapping("/admin/trip")
    public String index(Model model,
        @RequestParam(value="kw", required = false) String tripName) {
        model.addAttribute("tripList", this.tripService.getListTrip());
        return "trip-list";
    }

    @GetMapping("/admin/trip/create")
    public String formTrip(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("locationList", this.locationService.getListLocation(""));
        return "trip-form";
    }

    @PostMapping("/admin/trip/create")
    public String createTrip(Model model,
            @ModelAttribute("trip") @Valid Trip trip,
            BindingResult result) {
        model.addAttribute("locationList", this.locationService.getListLocation(""));

        if (result.hasErrors()) {
            return "trip-form";
        }

        if (this.tripService.createTrip(trip) == true) {
            return "redirect:/admin/trip";
        }

        model.addAttribute("errMsg", "Hệ thống đã xảy ra lỗi! Vui lòng thử lại sau!");

        return "trip-form";
    }
}
