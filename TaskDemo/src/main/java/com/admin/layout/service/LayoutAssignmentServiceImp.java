package com.admin.layout.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.layout.entity.GroupEntity;
import com.admin.layout.entity.LayoutAssignmentEntity;
import com.admin.layout.entity.LayoutEntity;
import com.admin.layout.entity.UserEntity;
import com.admin.layout.repository.GroupRepository;
import com.admin.layout.repository.LayoutAssignmentRepository;
import com.admin.layout.repository.LayoutRepository;
import com.admin.layout.repository.UserRepository;



@Service
public class LayoutAssignmentServiceImp implements LayoutAssignmentService{
@Autowired
private LayoutAssignmentRepository layoutAssignmentRepository;
@Autowired
private LayoutRepository layoutRepository;
@Autowired
private UserRepository userRepository;
@Autowired
private GroupRepository groupRepository;
	@Override
	public String assignLayout(Long layoutId, Long userId, Long groupId) {
		Optional<LayoutEntity>layout=layoutRepository.findById(layoutId);
		if(layout.isEmpty()) {
			return "Layout not found";	
		}
		LayoutAssignmentEntity assignment=new LayoutAssignmentEntity();
		assignment.setLayout(layout.get());
		if(userId!=null) {
			Optional<UserEntity>user=userRepository.findById(userId);
			if(user.isEmpty()) {
			return "User Not Found";
		}
			assignment.setUser(user.get());
		}else if(groupId!=null){
				Optional<GroupEntity>groupr=groupRepository.findById(groupId);
				if(groupr.isEmpty()) {
					return "Group Not Found";
				}
				assignment.setGroup(groupr.get());	
			}
		else {
			return "Either userId or groupId must be provided!";
		}
		layoutAssignmentRepository.save(assignment);
		return "Layout assigned successfully";
	}
	/*
	 * @Override public String updateLayout(Long userId,Long assignedId, Long
	 * newLayoutId) {
	 * Optional<LayoutAssignmentEntity>assignment=layoutAssignmentRepository.
	 * findById(assignedId); if(assignment.isEmpty()) { return
	 * "Assignment not found"; }
	 * Optional<LayoutEntity>layout=layoutRepository.findById(newLayoutId);
	 * if(layout.isEmpty()) { return "Layout not found"; } LayoutAssignmentEntity
	 * updatedAssignment=assignment.get();
	 * updatedAssignment.setLayout(layout.get());
	 * layoutAssignmentRepository.save(updatedAssignment); return
	 * "Layout updated successfully"; }
	 */
	
	
	//Fetches the layout assigned to user
	@Override
	public LayoutEntity getUserLayout(Long userId) {
		Optional<LayoutAssignmentEntity>userAssignment=layoutAssignmentRepository.findByUserId(userId);
		return userAssignment.map(LayoutAssignmentEntity::getLayout).orElse(null);
	}
	@Override
	public LayoutEntity getGroupLayout(Long groupId) {
		Optional<LayoutAssignmentEntity>groupAssignment=layoutAssignmentRepository.findByGroupId(groupId);
		return groupAssignment.map(LayoutAssignmentEntity::getLayout).orElse(null);
	
	
	
	}
	@Override
	public String updateLayout(Long userId,Long groupId, Long layoutId, Long newLayoutId) {
		Optional<LayoutEntity>newLayout=layoutRepository.findById(newLayoutId);
		if(newLayout.isEmpty()) {
			return "New layout not found";
		}
		Optional<LayoutAssignmentEntity> layoutAssignmentEntityOptional;
		 if(userId!=null) {
			 layoutAssignmentEntityOptional=layoutAssignmentRepository.findByUserIdAndLayoutId(userId,layoutId);
		}
			
		 else if(groupId!=null) {
			 layoutAssignmentEntityOptional=layoutAssignmentRepository.findByGroupIdAndLayoutId(groupId,layoutId);
			}
		 else {
			 return"Either userId or groupId must be provided.";
		 }
		 if(layoutAssignmentEntityOptional.isEmpty()) {
			 return "Assigned entity with given user/group and layout Id not found";
		 }
		 LayoutAssignmentEntity assignmentEntity= layoutAssignmentEntityOptional.get();
		 assignmentEntity.setLayout(newLayout.get());
		 layoutAssignmentRepository.save(assignmentEntity);
		return "Success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	
	
	
	
	
	

	

