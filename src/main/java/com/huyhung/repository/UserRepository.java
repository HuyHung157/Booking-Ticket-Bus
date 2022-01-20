/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.repository;

import com.huyhung.pojo.User;
import java.util.List;

/**
 *
 * @author TIM
 */
public interface UserRepository {

    User getUserByUserName(String username);

    boolean createUser(User user);

    List<User> getListUser(String userName);
}
