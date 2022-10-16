package com.osvaldo.metaphorce.service;

import java.util.List;

import com.osvaldo.metaphorce.dto.request.EmployeeReqDto;
import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;

public interface EmployeeService {
	
	EmployeeResponseDto	saveEmployee(EmployeeReqDto employee);
	
	EmployeeResponseDto	updateEmployee(EmployeeReqDto employee,Long employeeId);
	
	EmployeeResponseDto getEmployees();


}
