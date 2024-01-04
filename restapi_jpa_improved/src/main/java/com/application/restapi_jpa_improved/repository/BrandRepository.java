package com.application.restapi_jpa_improved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.restapi_jpa_improved.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String>{

}
