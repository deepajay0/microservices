package com.example.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.DepartmentDTO;
import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private APIClient apiClient;
	//private WebClient webClient;
	//private RestTemplate restTemplate;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
				employeeDTO.getEmail(), employeeDTO.getDepartmentCode());
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDTO empDto = new EmployeeDTO(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode()

		);
		return empDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long empId) {
		Employee savedEmployee = employeeRepository.findById(empId).get();

//		ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + savedEmployee.getDepartmentCode(),
//				DepartmentDTO.class);
//
//		DepartmentDTO departmentDto = responseEntity.getBody();
		
		//DepartmentDTO departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + savedEmployee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDTO.class).block();
		
		DepartmentDTO departmentDto = apiClient.getDepartment(savedEmployee.getDepartmentCode());
		
		
		EmployeeDTO empDto = new EmployeeDTO(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode()

		);
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployeeDTO(empDto);
		apiResponseDto.setDepartmentDTO(departmentDto);
		return apiResponseDto;
	}

}
