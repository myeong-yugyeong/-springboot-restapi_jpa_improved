package com.application.restapi_jpa_improved;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.restapi_jpa_improved.model.Brand;
import com.application.restapi_jpa_improved.model.Product;
import com.application.restapi_jpa_improved.repository.ProductRepository;

@SpringBootTest // @SpringBootTest 애너테이션을 사용하여 스프링 부트의 테스트 환경을 구성한다. 
public class ProductTest {
	
	@Autowired
	private ProductRepository productRepository;

	@Test // @Test 애너테이션을 사용하여 테스트 케이스를 정의한다. 
	public void createProduct() {
		
		Product product = new Product();
		product.setProductId(100l);
		product.setProductNm("테스트상품");
		product.setPrice(9876);
		product.setDeliveryPrice(543);
		product.setEnrollDt(new Date());
		Brand brand = new Brand();
		brand.setBrandId("b1");
		product.setBrand(brand);
		
		productRepository.save(product);
	}
	
}
