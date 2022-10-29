package com.osvaldo.metaphorce.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReqDto implements Serializable {

	private static final long serialVersionUID = 1L;

	

	private String taxIdNumber;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private String email;
	private String cellPhone;
	private Boolean isActive;

	


}
