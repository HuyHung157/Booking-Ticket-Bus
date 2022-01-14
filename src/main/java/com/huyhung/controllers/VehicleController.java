/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.service.VehicleService;
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
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/admin/vehicle")
    public String index() {
        return "vehicle-list";
    }

    @RequestMapping("/admin/vehicle/create")
    public String vehicleCreate() {
        return "vehicle-form";
    }
}
