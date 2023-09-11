package com.example.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	//build save department rest api
	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO saveDepartment = departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(saveDepartment,HttpStatus.CREATED);
	}
	
	//build get deparment rest api
	@GetMapping("{departmentCode}")
	public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable String departmentCode){
		DepartmentDTO getDepart = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<DepartmentDTO>(getDepart,HttpStatus.OK);
	}
}
