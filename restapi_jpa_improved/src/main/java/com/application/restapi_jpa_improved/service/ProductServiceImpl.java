package com.application.restapi_jpa_improved.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.restapi_jpa_improved.config.ProductMapper;
import com.application.restapi_jpa_improved.dto.ProductDTO;
import com.application.restapi_jpa_improved.model.Product;
import com.application.restapi_jpa_improved.repository.BrandRepository;
import com.application.restapi_jpa_improved.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	
	@Override
	public List<ProductDTO> getAllProducts() {
		return ProductMapper.toDTOList(productRepository.findAll());
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		return ProductMapper.toDTO(productRepository.findById(productId).orElse(null));
	}

	@Override
	public void createProduct(ProductDTO productDTO) {
		Product product = ProductMapper.toEntity(productDTO);
		product.setBrand(brandRepository.findById(productDTO.getBrandId()).orElse(null));
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Long productId, ProductDTO productDTO) {
			
		Product product = productRepository.findById(productId).orElse(null);
		product.setProductNm(productDTO.getProductNm());
		product.setPrice(productDTO.getPrice());
		product.setDeliveryPrice(productDTO.getDeliveryPrice());
		product.setEnrollDt(productDTO.getEnrollDt());
		product.setBrand(brandRepository.findById(productDTO.getBrandId()).orElse(null));
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDTO> findByDeliveryPrice(Integer devlieryPrice) {
		return ProductMapper.toDTOList(productRepository.findByDeliveryPrice(devlieryPrice));
	}

	@Override
	public List<ProductDTO> findByBetweenPrice(Integer begin, Integer end) {
		return ProductMapper.toDTOList(productRepository.findByBetweenPrice(begin, end));
	}

	@Override
	public List<Map<String,Object>> findByNativeJoin() {
		return productRepository.findByNativeJoin();
	}


}
