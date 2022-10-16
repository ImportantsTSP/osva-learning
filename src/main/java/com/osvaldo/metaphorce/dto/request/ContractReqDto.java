package com.osvaldo.metaphorce.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContractReqDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Long salaryPerDay;
	private Boolean isActive;	
	private LocalDate dateCreated;
	private Long contractTypeId;
	private Long employeeId;


	

}
