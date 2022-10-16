package com.osvaldo.metaphorce.service;

import com.osvaldo.metaphorce.dto.request.ContractReqDto;
import com.osvaldo.metaphorce.dto.request.EmployeeReqDto;
import com.osvaldo.metaphorce.dto.response.ContractResponseDto;
import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;

public interface ContractService {
	

	ContractResponseDto saveContract(ContractReqDto contractReqDto);

	ContractResponseDto deleteContract(Long employeeId);



}
