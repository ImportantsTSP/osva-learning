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
public class EmployeeDataDto {
	private List<EmployeeDto> employees;

}
