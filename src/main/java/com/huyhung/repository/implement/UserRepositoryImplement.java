/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository.implement;

import com.huyhung.pojo.User;
import com.huyhung.pojo.Vehicle;
import com.huyhung.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class UserRepositoryImplement implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUserByUserName(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        query = query.where(builder.equal(root.get("username").as(String.class), username));

        javax.persistence.Query q = session.createQuery(query);
        return (User) q.getSingleResult();
    }

    @Override
    public boolean createUser(User user) {
        
        Session session = this.sessionFactory.getObject().getCurrentSession();
        if(session.isOpen())
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            session.clear();
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getListUser(String userName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        
        if (userName != null && !userName.isEmpty()) {
            Predicate p = builder.equal(root.get("userName").as(String.class), userName.trim());
            query = query.where(p);
        }
        
        javax.persistence.Query q = session.createQuery(query);
        return q.getResultList();
    }

}