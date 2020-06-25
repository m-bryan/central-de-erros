package com.codenation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codenation.entities.User;
import com.codenation.repository.UserRepository;
import com.codenation.service.interfaces.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface, UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
