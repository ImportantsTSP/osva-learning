package com.osvaldo.metaphorce.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private ResultDto result;
	private EmployeeDataDto data;

}
