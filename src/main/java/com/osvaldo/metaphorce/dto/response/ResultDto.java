package com.osvaldo.metaphorce.dto.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String info;
	private String message;

}
