/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service;

import com.huyhung.pojo.User;
import com.huyhung.pojo.Vehicle;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author TIM
 */
public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);

    boolean createUser(User user);

    Map<String, String> getRoleList();

    List<User> getListUser(String userName);
}
