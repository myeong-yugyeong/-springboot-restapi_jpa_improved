package com.application.restapi_jpa_improved.service;

import java.util.List;
import java.util.Map;

import com.application.restapi_jpa_improved.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> getAllProducts();
	public ProductDTO getProductById(Long productId);
	public void createProduct(ProductDTO productDTO);
	public void updateProduct(Long productId , ProductDTO productDTO);
	public void deleteProduct(Long productId);
	
	// SQL 사용예시
	public List<ProductDTO> findByDeliveryPrice(Integer devlieryPrice);
	public List<ProductDTO> findByBetweenPrice(Integer begin , Integer end);
	public List<Map<String,Object>> findByNativeJoin();
	
}
