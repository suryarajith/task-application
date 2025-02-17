package com.admin.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.layout.entity.LayoutAssignmentEntity;
import com.admin.layout.entity.LayoutEntity;
import com.admin.layout.service.LayoutAssignmentService;

@RestController
@RequestMapping("/api/assignment")
public class LayoutAssignmentController {
	@Autowired
	private LayoutAssignmentService layoutAssignmentService;

	@PostMapping("/assign")
	public ResponseEntity<String> assignLayout(@RequestParam Long layoutId, @RequestParam(required = false) Long userId,
			@RequestParam(required = false) Long groupId) {
		String response = layoutAssignmentService.assignLayout(layoutId, userId, groupId);
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping("updatetest")
	public ResponseEntity<String>updateAssigedLayout(@RequestParam(required = false) Long userId,@RequestParam (required = false) Long groupId,@RequestParam Long layoutId, @RequestParam Long newLayoutId){
		String result=layoutAssignmentService.updateLayout(userId,groupId,layoutId,newLayoutId);
		if(result.equals("Success")) {
			return ResponseEntity.ok("Assigned layout updated successfully");
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@GetMapping("/user-layout")
	public ResponseEntity<LayoutEntity> getUserLayout(@RequestParam Long userId) {
		LayoutEntity layout = layoutAssignmentService.getUserLayout(userId);
		return layout != null ? ResponseEntity.ok(layout) : ResponseEntity.notFound().build();

	}

	
	  @GetMapping("/group-layout") 
	  public ResponseEntity<LayoutEntity>getGroupLayout(@RequestParam Long groupId){ LayoutEntity
	  grouplayout=layoutAssignmentService.getGroupLayout(groupId); return
	  grouplayout!=null?ResponseEntity.ok(grouplayout):ResponseEntity.notFound().
	  build();
	 

}
}
