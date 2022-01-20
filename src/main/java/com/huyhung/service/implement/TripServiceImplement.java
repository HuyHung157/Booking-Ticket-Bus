/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service.implement;

import com.huyhung.pojo.Trip;
import com.huyhung.repository.TripRepository;
import com.huyhung.service.TripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TIM
 */
@Service
public class TripServiceImplement implements TripService{
     @Autowired
    private TripRepository tripRepository;
    
    @Override
    public boolean createTrip(Trip trip) {        
        return this.tripRepository.createTrip(trip);
    }

    @Override
    public List<Trip> getListTrip() {
        return this.tripRepository.getListTrip();
    }
    
}
