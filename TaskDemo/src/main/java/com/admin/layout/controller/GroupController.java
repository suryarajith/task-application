package com.admin.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.layout.entity.GroupEntity;
import com.admin.layout.service.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
	@Autowired
	private GroupService groupService;
	@PostMapping("/insertgroup")
	public ResponseEntity<GroupEntity>addGroup(@RequestBody GroupEntity group){
	
		return  ResponseEntity.ok(groupService.addGroup(group));
		
	}

}
