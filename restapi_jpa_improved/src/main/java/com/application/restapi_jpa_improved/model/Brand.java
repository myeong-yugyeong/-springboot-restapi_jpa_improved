package com.application.restapi_jpa_improved.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Brand {

	@Id
	private String brandId;
	private String brandNm;
	private String activeYn;
	private Date enteredDt;
	
	
}
