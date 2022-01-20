/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service.implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.huyhung.pojo.Location;
import com.huyhung.repository.LocationRepository;
import com.huyhung.service.LocationService;
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
public class LocationServiceImplement implements LocationService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public boolean createLocation(Location location) {
        if (location.getFile() != null && location.getFile().getSize() > 0) {
            try {
                Map r = this.cloudinary.uploader().upload(location.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                location.setImgUrl((String) r.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(LocationServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.locationRepository.createLocation(location);
    }

    @Override
    public List<Location> getListLocation(String locationName) {
        return this.locationRepository.getListLocation(locationName);
    }

}
