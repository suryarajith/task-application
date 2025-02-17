package com.admin.layout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.layout.entity.UserEntity;
import com.admin.layout.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
@Autowired
private UserRepository userRepository;
	@Override
	public UserEntity addUser(UserEntity user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
