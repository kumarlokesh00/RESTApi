	package com.amdocs.RestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.amdocs.RestApi.model.Product;
import com.amdocs.RestApi.repo.ProductRepo;

@Service
public class ProductService {

	
	private ProductRepo productRepo;
	
	
	@Autowired
	public ProductService(ProductRepo productRepo) {
		
		this.productRepo = productRepo;
		
	}
	
	
	public List<Product> getAllProducts(){
		
		return productRepo.findAll();
	}
	
	
	
	public Product getProductById(Long id) {
		
		
		return productRepo.findById(id).orElse(null);
	}
	
	public Product createProduct( Product product) {
		return productRepo.save(product);
	}
	
	public Product updateProductName( Long id, Product product) {
		Product existingproduct = productRepo.findById(id).orElse(null);
		
		if(existingproduct!=null) {
			//existingproduct.setProductId(product.getProductId(id));
			existingproduct.setProductName(product.getProductName());
		
		}
		
		return productRepo.save(existingproduct);
	}
	
	public Product updateProductPrice( Long id, Product product) {
		Product existingproduct = productRepo.findById(id).orElse(null);
		
		if(existingproduct!=null) {
			//existingproduct.setProductId(product.getProductId(id));
			existingproduct.setProductPrice(product.getProductPrice());
		
		}
		
		return productRepo.save(existingproduct);
	}
	
	public void deleteProduct(Long id) {
		Product product = productRepo.findById(id).orElse(null);
		if(product!=null) {
			productRepo.delete(product);
		}
	}
	
	
	
	
}
