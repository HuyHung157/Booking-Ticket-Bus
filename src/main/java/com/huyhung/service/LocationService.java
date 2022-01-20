/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service;

import com.huyhung.pojo.Location;
import java.util.List;

/**
 *
 * @author TIM
 */
public interface LocationService {
    boolean createLocation(Location location);
    List<Location> getListLocation(String locationName);
}
