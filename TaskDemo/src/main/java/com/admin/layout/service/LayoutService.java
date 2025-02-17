package com.admin.layout.service;

import java.util.List;

import com.admin.layout.entity.LayoutEntity;

public interface LayoutService {

	LayoutEntity addlayout(LayoutEntity layout);

	List<LayoutEntity> getAlllayout();

}
