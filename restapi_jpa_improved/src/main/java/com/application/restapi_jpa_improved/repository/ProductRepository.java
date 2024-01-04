package com.application.restapi_jpa_improved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.restapi_jpa_improved.model.Product;
import java.util.List;
import java.util.Map;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

	// 기본키 외에 다른 컬럼 조회 예시
	// Spring Data JPA는 메소드 이름을 분석하여 특정 필드를 사용한 쿼리를 자동으로 생성하고 실행한다.
	public List<Product> findByDeliveryPrice(Integer deliveryPrice);
	

	/*
	  
	    - Native Query
	    
			@Query 어노테이션을 사용하여 SQL 쿼리를 직접 정의하고, nativeQuery = true로 설정하여 네이티브 SQL 쿼리를 사용한다.
			:파라메타 형식과 @Param 어노테이션을 사용하여 쿼리의 파라미터를 지정한다.
		
		- Native Query 이외에 데이터베이스와의 상호 작용을 위한 다양한 접근 방식을 제공한다.
		
			1) JPQL (Java Persistence Query Language) : JPQL은 JPA를 위한 객체 지향 쿼리 언어 
			2) Criteria API : Criteria API는 프로그래밍 방식으로 쿼리를 작성할 수 있게 해주는 API
			3) QueryDSL(Domain Specific Language) :  쿼리생성에 특화된 프레임워크
		
	*/
	
	// SQL 사용예시1
	@Query(value="select * from product where price between :begin and :end" , nativeQuery=true)
	public List<Product> findByBetweenPrice(@Param("begin") Integer begin , @Param("end") Integer end);
	
	// SQL 사용예시2
	@Query(value="select product_id as productId,"
			+ "	p.product_nm as productNm,"
			+ "	p.price as price,"
			+ "	p.delivery_price as deliveryPrice,"
			+ "	p.enroll_dt as enrollDt,"
			+ "	b.brand_id as brandId,"
			+ "	b.brand_nm as brandNm,"
			+ "	b.active_yn as activeYn,"
			+ "	b.entered_dt as enteredDt " 
			+"from	product	p , brand b " 
			+"where	p.brand_id	= b.brand_id " 
			+"and	b.active_yn	= 'Y'",	nativeQuery	=	true)
	public List<Map<String,Object>>findByNativeJoin();
	
}
