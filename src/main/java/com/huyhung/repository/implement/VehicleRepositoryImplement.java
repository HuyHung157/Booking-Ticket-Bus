/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository.implement;

import com.huyhung.pojo.Vehicle;
import com.huyhung.repository.VehicleRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TIM
 */
@Repository
@Transactional
public class VehicleRepositoryImplement implements VehicleRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(vehicle);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
