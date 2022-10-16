package com.osvaldo.metaphorce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldo.metaphorce.dto.request.ContractReqDto;
import com.osvaldo.metaphorce.dto.response.ContractResponseDto;
import com.osvaldo.metaphorce.service.ContractService;

@RestController
@RequestMapping("/contracts/v1")
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	
	@PostMapping("/contracts")
	public ResponseEntity<ContractResponseDto> createContract(@RequestBody ContractReqDto contractReqDto) {
		return new ResponseEntity<>(contractService.saveContract(contractReqDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/contracts/{employeeId}")
	public ResponseEntity<ContractResponseDto> deleteContract(@PathVariable Long employeeId){
				
		return new ResponseEntity<>(contractService.deleteContract(employeeId),HttpStatus.OK);
	}
	

}
