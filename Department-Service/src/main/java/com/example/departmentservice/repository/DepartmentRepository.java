package com.example.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.departmentservice.entity.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {
	Departments  findByDepartmentCode(String departmentCode);
	
}
