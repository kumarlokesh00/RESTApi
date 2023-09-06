package com.amdocs.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.RestApi.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

	

}
