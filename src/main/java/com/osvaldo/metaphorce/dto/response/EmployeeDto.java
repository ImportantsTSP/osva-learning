package com.osvaldo.metaphorce.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String taxIdNumber;
	private String fullName;
	private String email;
	private List<ContractDto> contracts;

}
