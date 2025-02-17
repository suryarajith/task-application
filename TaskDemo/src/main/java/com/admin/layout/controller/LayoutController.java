package com.admin.layout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.admin.layout.entity.LayoutEntity;
import com.admin.layout.service.LayoutService;

@RestController
@RequestMapping("/api/layout")
public class LayoutController {
	@Autowired
	private LayoutService layoutService;
	@PostMapping("/savelayout")
	public ResponseEntity<LayoutEntity>addlayout(@RequestBody LayoutEntity layout){
		
		return  ResponseEntity.ok(layoutService.addlayout(layout));
		
	}
	
	@GetMapping("/getAllLayouts")
	public ResponseEntity<List<LayoutEntity>>getAlllayout(){
		List<LayoutEntity>layout=layoutService.getAlllayout();
		return layout.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(layout);
	}

	

}
