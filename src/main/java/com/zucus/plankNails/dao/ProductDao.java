package com.zucus.plankNails.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zucus.plankNails.model.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
    @Query(nativeQuery=true,value ="SELECT * FROM product where active=1")
	List<Product> getActiveProducts();
}
