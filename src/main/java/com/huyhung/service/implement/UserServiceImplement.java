/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service.implement;

import com.huyhung.pojo.User;
import static com.huyhung.pojo.User.ADMIN;
import static com.huyhung.pojo.User.STAFF;
import static com.huyhung.pojo.User.USER;
import com.huyhung.repository.UserRepository;
import com.huyhung.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TIM
 */
@Service()
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> getRoleList() {
        Map<String, String> roleList = new HashMap<String, String>();
        roleList.put(USER, "Khách hàng");
        roleList.put(STAFF, "Nhân viên");
        roleList.put(ADMIN, "ADMIN");
        return roleList;
    }

}
