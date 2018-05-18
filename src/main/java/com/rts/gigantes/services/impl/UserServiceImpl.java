package com.rts.gigantes.services.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rts.gigantes.entities.User;
import com.rts.gigantes.repositories.RoleRepository;
import com.rts.gigantes.repositories.UserRepository;
import com.rts.gigantes.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRolesList(Collections.singletonList(roleRepository.findByRoleCode("admin")));
		userRepository.save(user);
	}

}
