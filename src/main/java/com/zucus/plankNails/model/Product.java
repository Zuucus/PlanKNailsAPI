package com.zucus.plankNails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
@Table(name = "Product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    
    @NotEmpty(message="* Please Enter productName")
    @Column(name = "product_name")
    private String productName;
    
    @NotEmpty(message="* Please Enter description")
    @Column(name = "description")
    private String description;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "in_stock")
    private int inStock;
    
    @Column(name = "colors")
    private String colors;
    
    @Column(name = "variant")
    private String variant;
    
    @Column(name = "weight")
    private String weight;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "best_seller")
    private boolean bestSeller;
    
    @Column(name = "is_visible")
    private boolean isVisible;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    
    
}
   