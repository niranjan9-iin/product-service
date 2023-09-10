package com.stackdev.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackdev.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
