package com.admin.layout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.layout.entity.LayoutEntity;
import com.admin.layout.repository.LayoutRepository;

@Service
public class LayoutServiceImp implements LayoutService{
@Autowired
private LayoutRepository layoutRepository;
	@Override
	public LayoutEntity addlayout(LayoutEntity layout) {
		
		return layoutRepository.save(layout);
	}
	@Override
	public List<LayoutEntity> getAlllayout() {
		return layoutRepository.findAll();
	}

}
