package com.example.departmentservice.service;

import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Departments;
import com.example.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}


	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		//convert department dto to department jpa entity
		
		Departments department = new Departments(
					departmentDTO.getId(),
					departmentDTO.getDepartmentName(),
					departmentDTO.getDepartmentDescription(),
					departmentDTO.getDepartmentCode()
				);
		Departments savedDepartment = departmentRepository.save(department);
		DepartmentDTO dDto = new DepartmentDTO(savedDepartment.getId(),
					savedDepartment.getDepartmentName(),
					savedDepartment.getDepartmentDescription(),
					savedDepartment.getDepartmentCode()
				);
				
		return dDto;
	}


	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {
		Departments department = departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDTO dDto = new DepartmentDTO(
					department.getId(),
					department.getDepartmentName(),
					department.getDepartmentDescription(),
					department.getDepartmentCode()
				);
				
		return dDto;
	}

}
