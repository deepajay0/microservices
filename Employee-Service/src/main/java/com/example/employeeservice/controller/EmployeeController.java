package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//build save Employee Rest api
	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDto){
		EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDTO>(saveEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{empId}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long empId){
		APIResponseDto employeeById = employeeService.getEmployeeById(empId);
		return new ResponseEntity<APIResponseDto>(employeeById,HttpStatus.OK);
	}
	
}
