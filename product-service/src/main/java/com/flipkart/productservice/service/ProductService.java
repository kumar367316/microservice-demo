package com.flipkart.productservice.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.productservice.entity.Product;
import com.flipkart.productservice.exception.DataNotFoundException;
import com.flipkart.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		product.setTransactionId(UUID.randomUUID().toString());

		return productRepository.save(product);

	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	public Product getUpdateProductByName(int quantity, String productName) {

		Product product = productRepository.findByProductName(productName);
		int totalQty = product.getQuantity();
		int updateQty = totalQty - quantity;
		product.setQuantity(updateQty);
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}

	public int getProductQuantity(String productName,int orderQty) {
		int existingQty = 0;
		Product product = productRepository.findByProductName(productName);
		if (Objects.nonNull(product)) {
			existingQty = product.getQuantity();
		} else {
			throw new DataNotFoundException("quantity insufficent for " + productName);
		}
		int updateQuantity = existingQty - orderQty;
		product.setQuantity(updateQuantity);
		productRepository.save(product);
		return existingQty;
	}
}
