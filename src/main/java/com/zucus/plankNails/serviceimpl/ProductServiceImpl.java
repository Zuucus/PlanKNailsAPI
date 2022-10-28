package com.zucus.plankNails.serviceimpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zucus.plankNails.constants.Constants;
import com.zucus.plankNails.dao.ProductDao;
import com.zucus.plankNails.model.Product;



@Service("ProductServiceImpl")
public class ProductServiceImpl  {
	@Autowired 
	ProductDao productDao;


	@Autowired
	private ModelMapper modelMapper;


	public ResponseEntity<Map<String, String>> save(Product product) {
		product.setCreatedAt(LocalDateTime.now());
		product.setUpdatedAt(LocalDateTime.now());
		Map<String, String> response = new HashMap<>();
		productDao.save(product);
		response.put(Constants.MESSAGE, "Product saved");
		response.put("product",product.getProductName());
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);

	}
	
	
	public List<Product> getAllProducts() {
		List<Product>product =productDao.findAll();
		return product;
	}

	public Optional<Product> getProductsById(int productId) {
		Optional<Product>product =productDao.findById(productId);
		return product;
	}

    public ResponseEntity<Map<String, String>> updateProductById (int productId,Product productionDetails) {
    	Map<String, String> response = new HashMap<>();
    	try {
			Product product=productDao.findById(productId).get();
			productionDetails.setProductId(productId);
			productionDetails.setCreatedAt(product.getCreatedAt());
			productionDetails.setUpdatedAt(LocalDateTime.now());
			productDao.save(productionDetails);
			response.put(Constants.MESSAGE, "product updated");
			response.put("product","");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}catch(Exception ex) {
			response.put(Constants.MESSAGE, "product updation failed");
			response.put("error",ex.getMessage());
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
    	
    }
    
    public ResponseEntity<Map<String, String>> deleteProductById (int productId) {
    	Map<String, String> response = new HashMap<>();
		productDao.deleteById(productId);
		response.put(Constants.MESSAGE, "product deleted");
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
    }
    
	

}

