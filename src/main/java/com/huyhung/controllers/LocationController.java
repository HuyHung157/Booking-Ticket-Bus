/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.service.LocationService;
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
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/admin/location")
    public String index() {
        return "location-list";
    }
    
    @RequestMapping("/admin/location/create")
    public String locationCreate() {
        return "location-form";
    }
}
