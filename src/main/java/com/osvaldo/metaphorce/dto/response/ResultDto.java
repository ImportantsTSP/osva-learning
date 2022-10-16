package com.osvaldo.metaphorce.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultDto {
	
	private Integer statusCode;
	private String info;
	private String message;

}
