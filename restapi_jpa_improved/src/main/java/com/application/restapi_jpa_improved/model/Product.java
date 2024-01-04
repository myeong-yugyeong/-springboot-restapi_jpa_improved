package com.application.restapi_jpa_improved.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


/*


	1. JPA에서의 엔티티 관계는 단방향과 양방향으로 나뉜다.
	
		 - 단방향 관계
		
			 단방향 관계에서는 한 엔티티가 다른 엔티티를 참조하지만, 반대 방향은 참조하지 않는다.
			 이는 관계를 정의한 엔티티만이 관련 엔티티의 정보에 접근할 수 있음을 의미한다.
		
		- 양방향 관계
		
			양방향 관계에서는 두 엔티티가 서로를 참조한다.
			이렇게 함으로써, 각 엔티티는 상대방 엔티티의 정보에 접근하고 관리할 수 있다.
			양방향 관계를 설정하려면, 두 엔티티 모두에 관계를 정의해야 한다.
	
	
	2. JPA(Java Persistence API)에서의 매핑 관계는 객체 간의 관계를 데이터베이스 테이블 간의 관계로 변환하는 방법을 정의한다.
	
		- 일대일(One-to-One) 관계
	
			일대일 관계는 두 엔티티가 1:1 관계를 가지는 경우를 말한다.
			JPA에서는 @OneToOne 어노테이션을 사용하여 이 관계를 매핑한다.
			예: 사용자(User) 엔티티와 사용자 프로필(UserProfile) 엔티티 간의 관계.
	
		- 일대다(One-to-Many) 관계
	
			일대다 관계는 한 엔티티가 다른 엔티티 여러 개와 관계를 가지는 경우이다.
			JPA에서는 @OneToMany 어노테이션을 사용한다
			예: 한 명의 저자(Author)가 여러 권의 책(Book)을 출판한 경우.
	
		- 다대일(Many-to-One) 관계
	
			다대일 관계는 여러 엔티티가 단일 엔티티와 관계를 가지는 경우이다.
			@ManyToOne 어노테이션을 사용하여 매핑한다
			예: 여러 책(Book)이 하나의 저자(Author)에 속하는 경우.
	
		- 다대다(Many-to-Many) 관계
	
			다대다 관계는 두 엔티티 그룹이 서로 복잡하게 연결된 관계를 가질 때 사용된다.
			JPA에서는 @ManyToMany 어노테이션을 사용한다
			이 관계는 중간 조인 테이블(join table)을 통해 관리된다.
			예: 여러 학생(Student)이 여러 수업(Course)에 등록하는 경우.

*/

@Entity
@Data
public class Product {

	@Id
	private Long productId;
	private String productNm;
	private Integer price;
	private Integer deliveryPrice;
	private Date enrollDt;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand; 
	
	/*
	 
		
		- @ManyToOne
		
			Product와 Brand 간의 다대일(Many-to-One) 관계를 나타낸다. 
			즉, 하나의 브랜드가 여러 제품을 가질 수 있음을 의미한다.
		
		- @JoinColumn(name = "brand_id")
		
			연관된 브랜드를 참조하기 위한 외래 키(foreign key)가 brand_Id라는 이름의 열(column)에 저장됨을 명시한다.
		
		- private Brand brand;
		
			Product 엔티티와 연관된 Brand 엔티티의 인스턴스를 참조하는 필드이다.
			이 클래스를 통해, Product 엔티티는 Brand 엔티티와의 관계를 매핑하며, 
			이를 통해 ORM(Object-Relational Mapping)을 구현한다. 
		
	*/
	
	
	
	
	
	
	
	
	
	
	
}
