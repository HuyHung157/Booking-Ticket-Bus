/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository.implement;

import com.huyhung.pojo.Vehicle;
import com.huyhung.repository.VehicleRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
            session.clear();
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Vehicle> getListVehicle(String vehicleName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        Root root = query.from(Vehicle.class);
        query = query.select(root);
        
        if (vehicleName != null && !vehicleName.isEmpty()) {
            Predicate p = builder.equal(root.get("vehicleName").as(String.class), vehicleName.trim());
            query = query.where(p);
        }
        
        query = query.orderBy(builder.asc(root.get("vehicleNumber")));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
