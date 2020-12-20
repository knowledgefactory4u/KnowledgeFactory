package com.knf.dev.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.knf.dev.dto.UserRegistrationDto;
import com.knf.dev.model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	List<User> getAll();
}
