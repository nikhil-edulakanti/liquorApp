package com.example.liquorApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.liquorApp.entities.Products;


public interface ProductRepository extends JpaRepository<Products, Long> {
    // You can define custom query methods here if needed

    List<Products> findByCategory(String category);

    
} 