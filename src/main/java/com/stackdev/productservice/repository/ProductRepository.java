package com.stackdev.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackdev.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
