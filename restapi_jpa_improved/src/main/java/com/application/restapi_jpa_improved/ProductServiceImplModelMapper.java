
/*
 
	  - ModelMapper
	  
	   ModelMapper는 객체 간의 매핑을 간소화하기 위한 라이브러리이다. 
	   ModelMapper는 반복적인 매핑 코드를 줄여주어 주로 데이터 전송 객체(DTO)와 도메인 모델 사이의 데이터 변환에 사용된다. 
	   
	   [ 주요 메서드 ]
	
		map(Object source, Class<D> destinationType)
		 이 함수는 source 객체의 데이터를 destinationType 클래스의 새 인스턴스로 매핑한다.
    
*/

/*

package com.application.restapi_jpa_improved;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.restapi_jpa_Improved.dto.ProductDTO;
import com.application.restapi_jpa_Improved.model.Product;
import com.application.restapi_jpa_Improved.repository.BrandRepository;
import com.application.restapi_jpa_Improved.repository.ProductRepository;


@Service
public class ProductServiceImplModelMapper implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> productList = productRepository.findAll().stream() // 함수형 방식으로 처리할 수 있게반환
										.map(product -> modelMapper.map(product ,ProductDTO.class)) //각 Product 객체를 ProductDTO 객체로 변환
										.collect(Collectors.toList()); // 변환된 ProductDTO 객체들을 리스트로 수집하여 List로 변환
		return productList;
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		ProductDTO productDTO =  productRepository.findById(productId)
								 .map(product -> modelMapper.map(product, ProductDTO.class)).orElse(null);  //Product 객체를 ProductDTO 객체로 변환
		return productDTO;
	}

	@Override
	public void createProduct(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class); // 새 인스턴스로 매핑하여 반환
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
	public List<ProductDTO> findByDeliveryPrice(Integer deliveryPrice) {
		List<ProductDTO> productList =  productRepository.findByDeliveryPrice(deliveryPrice).stream()
						                .map(product -> modelMapper.map(product, ProductDTO.class))
						                .collect(Collectors.toList());
		return productList;
		
	}

	@Override
	public List<ProductDTO> findByBetweenPrice(Integer begin, Integer end) {
		List<ProductDTO> productList =  productRepository.findByBetweenPrice(begin , end).stream()
						                .map(product -> modelMapper.map(product, ProductDTO.class))
						                .collect(Collectors.toList());
		return productList;
	}

	@Override
	public List<Map<String,Object>> findByNativeJoin() {
		return productRepository.findByNativeJoin();
	}
	
}

*/