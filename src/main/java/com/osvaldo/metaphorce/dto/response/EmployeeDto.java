package com.osvaldo.metaphorce.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class EmployeeDto {
	
	private String taxIdNumber;
	private String fullName;
	private String email;
	private List<ContractDto> contracts;

}
