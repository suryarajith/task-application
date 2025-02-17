package com.admin.layout.service;

import com.admin.layout.entity.LayoutAssignmentEntity;
import com.admin.layout.entity.LayoutEntity;

public interface LayoutAssignmentService {

	String assignLayout(Long layoutId, Long userId, Long groupId);

	String updateLayout(Long userId,Long groupId,Long layoutId, Long newLayoutId);

	LayoutEntity getUserLayout(Long userId);

	LayoutEntity getGroupLayout(Long groupId);



}
