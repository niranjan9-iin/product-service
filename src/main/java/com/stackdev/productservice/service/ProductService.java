package com.stackdev.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackdev.productservice.dto.ProductRequest;
import com.stackdev.productservice.dto.ProductResponse;
import com.stackdev.productservice.model.Product;
import com.stackdev.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepo;

	public void createProduct(ProductRequest productReq) {
		Product product = Product.builder().name(productReq.getName()).description(productReq.getDescription())
				.price(productReq.getPrice()).build();
		productRepo.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}
}
