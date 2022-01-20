/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service.implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.huyhung.pojo.Vehicle;
import com.huyhung.repository.VehicleRepository;
import com.huyhung.service.VehicleService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TIM
 */
@Service
public class VehicleServiceImplement implements VehicleService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        if (vehicle.getFile() != null && vehicle.getFile().getSize() > 0) {
            try {
                Map r = this.cloudinary.uploader().upload(vehicle.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                vehicle.setImgUrl((String) r.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(LocationServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.vehicleRepository.createVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getListVehicle(String vehicleName) {
        return this.vehicleRepository.getListVehicle(vehicleName);
    }
}
