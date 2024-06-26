package com.osvaldo.metaphorce.dto.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ContractDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Long salaryPerDay;


}
