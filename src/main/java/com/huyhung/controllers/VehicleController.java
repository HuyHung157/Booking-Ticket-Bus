/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.controllers;

import com.huyhung.pojo.Vehicle;
import com.huyhung.service.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String vehicleCreate(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle-form";
    }

    @PostMapping("/admin/vehicle/create")
    public String createLocation(Model model,
            @ModelAttribute("vehicle") @Valid Vehicle vehicle,
            BindingResult result) {

        if (result.hasErrors()) {
            return "vehicle-form";
        }

        if (this.vehicleService.createVehicle(vehicle) == true) {
            return "redirect:/admin/vehicle";
        }

        model.addAttribute("errMsg", "He thong da xay ra loi! Vui long quay lai sau!");
        return "vehicle-form";
    }
}
