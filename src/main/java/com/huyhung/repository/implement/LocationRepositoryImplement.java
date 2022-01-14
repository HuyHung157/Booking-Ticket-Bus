/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository.implement;

import com.huyhung.pojo.Location;
import com.huyhung.repository.LocationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TIM
 */
@Repository
@Transactional
public class LocationRepositoryImplement implements LocationRepository {

    @Override
    public boolean createLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
