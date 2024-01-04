package com.application.restapi_jpa_improved.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {

	private Long productId;
	private String productNm;
	private Integer price;
	private Integer deliveryPrice;
	private Date enrollDt;
	private String brandId;
	
}
