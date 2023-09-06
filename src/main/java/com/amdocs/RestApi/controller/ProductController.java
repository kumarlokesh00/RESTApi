package com.amdocs.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.RestApi.model.Product;
import com.amdocs.RestApi.service.ProductService;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
	
	
	private ProductService productService;
	
	@Autowired
	public ProductController( ProductService productService) {
		this.productService  = productService;
	}
	
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/createproduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/updateName/{id}")
	public Product updateProductName(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProductName(id, product);
	}
	
	@PutMapping("/updatePrice/{id}")
	public Product updateProductPrice(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProductPrice(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		 productService.deleteProduct(id);
	}

}
