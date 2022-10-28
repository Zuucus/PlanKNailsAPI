package com.zucus.plankNails.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zucus.plankNails.model.Product;
import com.zucus.plankNails.serviceimpl.ProductServiceImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/plank/")

public class  ProductController{
	@Autowired
	private ProductServiceImpl productServiceImpl;   
	

	@PostMapping("product")	
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Map<String, String>> saveProduct(@RequestBody Product newProduct){
		return productServiceImpl.save(newProduct);
	}

	@GetMapping("product")
	public List<Product> allProducts() {
		return productServiceImpl.getAllProducts();
	}

	@GetMapping("product/{productId}")
	public Optional<Product> productById(@PathVariable (value="productId")@NonNull int productId) {
		return productServiceImpl.getProductsById(productId);

	}

	@PutMapping("product/{productId}")
	public ResponseEntity<Map<String, String>> updateProductById(@PathVariable (value="productId")@NonNull int productId,
		 @RequestBody Product productDetails) {
		return productServiceImpl.updateProductById(productId,productDetails);

	}

	@DeleteMapping("product/{productId}")
	public ResponseEntity<Map<String, String>> deleteProductById(@PathVariable (value="productId")@NonNull int productId) {
		return productServiceImpl.deleteProductById(productId);

	}
	

}



