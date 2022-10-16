package com.osvaldo.metaphorce.dto.request;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.osvaldo.metaphorce.entity.ContractType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeReqDto {

	

	private String taxIdNumber;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private String email;
	private String cellPhone;
	private Boolean isActive;

	


}
