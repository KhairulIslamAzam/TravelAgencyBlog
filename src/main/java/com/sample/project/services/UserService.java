package com.sample.project.services;

import com.sample.project.dto.UserDto;
import com.sample.project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User save(UserDto userDto);
    Optional<org.springframework.security.core.userdetails.User> getCurrentUser();
}
