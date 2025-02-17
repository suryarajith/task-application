package com.admin.layout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.layout.entity.GroupEntity;
import com.admin.layout.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService{
   @Autowired
   private GroupRepository groupRepository;
	@Override
	public GroupEntity addGroup(GroupEntity group) {
		return groupRepository.save(group);
	}

}
