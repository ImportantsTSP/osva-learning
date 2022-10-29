package com.osvaldo.metaphorce.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;
import com.osvaldo.metaphorce.entity.Employee;
import com.osvaldo.metaphorce.repository.EmployeeRepository;
import com.osvaldo.metaphorce.service.imp.EmployeeServiceImp;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@InjectMocks
	private EmployeeServiceImp employeeServiceImp;

	@Mock
	EmployeeRepository employer;

	@Test
	void getEmployees() {

//		Page<Employee> pageEmp = Mockito.mock(Page.class);

		List<Employee> employees = new ArrayList<>();
		Page<Employee> pageEmp = new PageImpl<Employee>(employees);
		Mockito.when(employer.findByIsActive(Mockito.any(), Mockito.any())).thenReturn(pageEmp);

		EmployeeResponseDto emp = employeeServiceImp.getEmployees(1, 1);

		assertAll(() -> assertEquals(200, emp.getResult().getStatusCode()),
				() -> assertEquals("Ok", emp.getResult().getInfo()));

	}
	
	
/*	@Test
	void getEmployeesFail() {

//		Page<Employee> pageEmp = Mockito.mock(Page.class);

		List<Employee> employees = new ArrayList<>();
		Page<Employee> pageEmp = new PageImpl<Employee>(employees);
//		Mockito.when(employer.findByIsActive(Mockito.any(), Mockito.any())).thenReturn(pageEmp);

//		EmployeeResponseDto emp = employeeServiceImp.getEmployees(1, 1);

		assertThrows(Exception.class, ()-> employeeServiceImp.getEmployees(1,1));

	}*/

}
