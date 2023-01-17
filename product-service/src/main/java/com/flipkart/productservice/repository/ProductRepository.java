package com.flipkart.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Product findByProductName(String productName);
}
