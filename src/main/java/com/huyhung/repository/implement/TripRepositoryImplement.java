/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository.implement;

import com.huyhung.pojo.Trip;
import com.huyhung.repository.TripRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TIM
 */
@Repository
@Transactional
public class TripRepositoryImplement implements TripRepository{

    @Override
    public boolean createTrip(Trip trip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
