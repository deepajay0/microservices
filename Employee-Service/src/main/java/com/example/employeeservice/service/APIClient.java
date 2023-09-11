package com.example.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeservice.dto.DepartmentDTO;

@FeignClient(name="DEPARTMENT-SERVICE")
//@FeignClient(url = "http://localhost:8080",value="DPARTMENT-SERVICE")
public interface APIClient {
	@GetMapping("api/departments/{departmentCode}")
	DepartmentDTO getDepartment(@PathVariable String departmentCode);
}
