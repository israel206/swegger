package com.crud.swegger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.swegger.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findById(long id);

}
