package com.example.employeeservice.dto;

public class APIResponseDto {
	private EmployeeDTO employeeDTO;
	private DepartmentDTO departmentDTO;
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}
	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	public APIResponseDto(EmployeeDTO employeeDTO, DepartmentDTO departmentDTO) {
		super();
		this.employeeDTO = employeeDTO;
		this.departmentDTO = departmentDTO;
	}
	public APIResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
