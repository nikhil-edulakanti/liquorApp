package com.example.liquorApp.controller;

import com.example.liquorApp.service.ProductService;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.liquorApp.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

   
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
