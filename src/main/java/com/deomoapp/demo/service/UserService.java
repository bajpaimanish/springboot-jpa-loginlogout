package com.deomoapp.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.deomoapp.demo.model.User;
import com.deomoapp.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
