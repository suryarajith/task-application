package com.admin.layout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.layout.entity.LayoutEntity;

@Repository
public interface LayoutRepository extends JpaRepository<LayoutEntity, Long>{

}
