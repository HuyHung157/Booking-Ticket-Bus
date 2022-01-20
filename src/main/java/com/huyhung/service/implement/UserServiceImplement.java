/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.service.implement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.huyhung.pojo.User;
import static com.huyhung.pojo.User.ADMIN;
import static com.huyhung.pojo.User.STAFF;
import static com.huyhung.pojo.User.USER;
import com.huyhung.repository.UserRepository;
import com.huyhung.service.UserService;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author TIM
 */
@Service("userDetailsService")
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map<String, String> getRoleList() {
        Map<String, String> roleList = new HashMap<String, String>();
        roleList.put(USER, "Khách hàng");
        roleList.put(STAFF, "Nhân viên");
        roleList.put(ADMIN, "ADMIN");
        return roleList;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username!!!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getFile() != null && user.getFile().getSize() > 0) {
            try {
                Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setImgUrl((String) r.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.userRepository.createUser(user);
    }

    @Override
    public List<User> getListUser(String userName) {
        return this.userRepository.getListUser(userName);
    }

}
