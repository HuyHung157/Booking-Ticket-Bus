/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.Location;
import com.huyhung.service.LocationService;
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
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/admin/location")
    public String index(Model model,
            @RequestParam(value="kw", required = false) String locationName) {
        model.addAttribute("locationList", this.locationService.getListLocation(locationName));
        return "location-list";
    }

    @GetMapping("/admin/location/create")
    public String formLocation(Model model) {
        model.addAttribute("location", new Location());
        return "location-form";
    }

    @PostMapping("/admin/location/create")
    public String createLocation(Model model,
            @ModelAttribute("location") @Valid Location location,
            BindingResult result) {

        if (result.hasErrors()) {
            return "location-form";
        }

        if (this.locationService.createLocation(location) == true) {
            return "redirect:/admin/location";
        }

        model.addAttribute("errMsg", "Hệ thống đã xảy ra lỗi! Vui lòng thử lại sau!");
        return "location-form";
    }
}
