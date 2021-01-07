package com.sample.project.utils;

import com.sample.project.model.User;
import com.sample.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    @Autowired
    private  UserRepository userRepository;

    public  User userInfo() {
        String username = getUserName();
        System.out.println("--> test"+ username);
        User user = userRepository.findByEmail(username);
        return user;
    }

    private  String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
