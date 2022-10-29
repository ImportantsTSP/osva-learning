package com.osvaldo.metaphorce.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.osvaldo.metaphorce.dto.request.EmployeeReqDto;
import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;
import com.osvaldo.metaphorce.dto.response.ResultDto;
import com.osvaldo.metaphorce.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService iEmployeeService;
	
	private ObjectMapper objectMapper;
	@BeforeEach
	void setUp() {
		 objectMapper = new ObjectMapper();
	}
	
	
	@Test
	void updateEmployee() throws Exception {
		EmployeeReqDto emp=EmployeeReqDto.builder()
				.build();

		String str="{\r\n"
				+ "  \"birthDate\": \"2022-10-29\",\r\n"
				+ "  \"cellPhone\": \"string\",\r\n"
				+ "  \"email\": \"string\",\r\n"
				+ "  \"isActive\": true,\r\n"
				+ "  \"lastName\": \"string\",\r\n"
				+ "  \"name\": \"string\",\r\n"
				+ "  \"taxIdNumber\": \"string\"\r\n"
				+ "}";
		
		EmployeeResponseDto resp =	EmployeeResponseDto.builder()
		.result(ResultDto.builder().statusCode(200).info("").message("").build()).build();
		
		
		mockMvc.perform(put("/employees/v1/employees/1")
				.content(objectMapper.writeValueAsString(emp))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
		
	}

	@Test
	void getEmployees() throws Exception {
		EmployeeResponseDto emplR = EmployeeResponseDto.builder()
				.result(ResultDto.builder().statusCode(200).info("200").message("List Employees").build()).build();

		Mockito.when(iEmployeeService.getEmployees(Mockito.any(), Mockito.any())).thenReturn(emplR);

		mockMvc.perform(get("/employees/v1/employees?page=1&size=1").contentType(MediaType.APPLICATION_JSON)

		).andExpect(status().is2xxSuccessful());

	}

}
