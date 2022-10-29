package com.osvaldo.metaphorce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldo.metaphorce.dto.request.EmployeeReqDto;
import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;
import com.osvaldo.metaphorce.service.EmployeeService;

@RestController
@RequestMapping("/employees/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeReqDto employee) {

		return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{idEmployee}")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(@RequestBody EmployeeReqDto employee,
			@PathVariable Long idEmployee) {

		return new ResponseEntity<>(employeeService.updateEmployee(employee, idEmployee), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public ResponseEntity<EmployeeResponseDto> getEmployees(@RequestParam Integer page,@RequestParam Integer size) {

		

		return new ResponseEntity<>(employeeService.getEmployees(page,size), HttpStatus.OK);
	}

}
