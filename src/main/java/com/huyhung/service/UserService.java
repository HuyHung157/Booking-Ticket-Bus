/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service;

import com.huyhung.pojo.User;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author TIM
 */
public interface UserService {
    User getUserByUserName(String username);
    Map<String, String> getRoleList();
    boolean createUser(User user);
}
