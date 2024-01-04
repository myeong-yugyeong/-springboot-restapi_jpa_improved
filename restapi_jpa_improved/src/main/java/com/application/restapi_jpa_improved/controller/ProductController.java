package com.application.restapi_jpa_improved.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.restapi_jpa_improved.dto.ProductDTO;
import com.application.restapi_jpa_improved.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getAllProduct(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public ProductDTO getProductById(@PathVariable("productId") Long productId) {
		return productService.getProductById(productId);
	}
	
	@PostMapping
	public void createProduct (@RequestBody ProductDTO productDTO) {
		productService.createProduct(productDTO);
	}
	
	@PutMapping("/{productId}")
	public void updateProduct(@PathVariable("productId") Long productId , @RequestBody ProductDTO productDTO) {
		productService.updateProduct(productId, productDTO);
	} 
	
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
	}

	@GetMapping("/sqlEx01")
	public List<ProductDTO> findByDeliveryPrice() {
		return productService.findByDeliveryPrice(2500);
	}
	
	@GetMapping("/sqlEx02")
	public List<ProductDTO> findByBetweenPrice() {
		return productService.findByBetweenPrice(500000 , 1000000);
	}
	
	@GetMapping("/sqlEx03")
	public List<Map<String,Object>> findByNativeJoin() {
		return productService.findByNativeJoin();
	}
	
}
