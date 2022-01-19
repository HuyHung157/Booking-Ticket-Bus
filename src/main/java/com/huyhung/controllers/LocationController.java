/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.huyhung.pojo.Location;
import com.huyhung.service.LocationService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping("/admin/location")
    public String index() {
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

        model.addAttribute("errMsg", "He thong da xay ra loi! Vui long quay lai sau!");
        return "location-form";
    }
}
