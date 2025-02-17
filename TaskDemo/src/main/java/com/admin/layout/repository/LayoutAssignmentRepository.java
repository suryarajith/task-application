package com.admin.layout.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.layout.entity.LayoutAssignmentEntity;

@Repository
public interface LayoutAssignmentRepository extends JpaRepository<LayoutAssignmentEntity, Long>{
Optional<LayoutAssignmentEntity>findByUserId(Long userId);
Optional<LayoutAssignmentEntity>findByGroupId(Long groupId);
Optional<LayoutAssignmentEntity>findByUserIdAndLayoutId(Long userId,Long layoutId);
Optional<LayoutAssignmentEntity>findByGroupIdAndLayoutId(Long groupId,Long layoutId);
}
