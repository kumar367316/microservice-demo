package com.flipkart.productservice.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.productservice.entity.Product;
import com.flipkart.productservice.repository.ProductRepository;
import com.flipkart.productservice.service.ProductService;

@RestController
@RequestMapping("/product-management")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/getallproducts")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/products/{productName}")
	public Product getProductByName(@PathVariable String productName) {
		return productService.getProductByName(productName);
	}
	
	@PutMapping("/updateproducts/{quantity}/{productName}")
	public Product getUpdateProductByName(@PathVariable int quantity,@PathVariable String productName) {
		return productService.getUpdateProductByName(quantity,productName);
	}
	
	@GetMapping("/getproductsqty/{productName}/{orderQty}")
	public int getProductQuantity(@PathVariable String productName,@PathVariable int orderQty) {
		return productService.getProductQuantity(productName,orderQty);
	}
}
