package com.admin.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.layout.entity.UserEntity;
import com.admin.layout.service.UserService;
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/insertuser")
	public ResponseEntity<UserEntity>addUser(@RequestBody UserEntity user){
	
		return  ResponseEntity.ok(userService.addUser(user));
		
	}

}
