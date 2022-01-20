/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service;

import com.huyhung.pojo.Trip;
import java.util.List;

/**
 *
 * @author TIM
 */
public interface TripService {
    boolean createTrip(Trip trip);
    List<Trip> getListTrip();
}
