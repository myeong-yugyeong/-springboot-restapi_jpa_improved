package com.application.restapi_jpa_improved.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.restapi_jpa_improved.dto.ProductDTO;
import com.application.restapi_jpa_improved.model.Product;

public class ProductMapper {

	public static Product toEntity(ProductDTO dto) {
		
		Product entity = new Product();
		entity.setProductId(dto.getProductId());
		entity.setProductNm(dto.getProductNm());
		entity.setPrice(dto.getPrice());
		entity.setDeliveryPrice(dto.getDeliveryPrice());
		entity.setEnrollDt(dto.getEnrollDt());
		
		return entity;
	}
	
	public static ProductDTO toDTO(Product entity) {
		
		ProductDTO dto = new ProductDTO();
		dto.setProductId(entity.getProductId());
		dto.setProductNm(entity.getProductNm());
		dto.setPrice(entity.getPrice());
		dto.setDeliveryPrice(entity.getDeliveryPrice());
		dto.setEnrollDt(entity.getEnrollDt());
		dto.setBrandId(entity.getBrand().getBrandId());
		
		return dto;
	}
	
	public static List<ProductDTO> toDTOList(List<Product> products){

		/*
		 
			객체.stream() : 스트림변환
			 
				- 객체.stream()을 통해 객체들의 스트림(Stream)을 생성한다.
				- 스트림은 자바 8부터 도입된 컬렉션을 효율적으로 처리하기 위한 API이다.
		
			.map(ProductMapper::toDTO) : 매핑
			
				- 구문은 각 entity 객체를 DTO 객체로 변환하는 작업을 수행한다. 
			 	-  ProductMapper::toDTO는 메소드 레퍼런스로, ProductMapper 클래스에 정의된 toDTO 메소드를 각 Product 객체에 적용한다.
			
			.collect(Collectors.toList()) : 결과 수집
			
				- 스트림을 통해 변환된 ProductDTO 객체들을 새로운 리스트로 수집한다.
	
		 */
		
		return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
	}
	
	
}
