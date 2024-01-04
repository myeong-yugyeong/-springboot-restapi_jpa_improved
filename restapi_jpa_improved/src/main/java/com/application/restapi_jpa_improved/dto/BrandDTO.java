package com.application.restapi_jpa_improved.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BrandDTO {

	private String brandId;
	private String brandNm;
	private String activeYn;
	private Date enteredDt;
	
}
