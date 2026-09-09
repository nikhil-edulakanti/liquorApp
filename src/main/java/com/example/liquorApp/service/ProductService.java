package com.example.liquorApp.service;
import java.util.List;

import com.example.liquorApp.dto.response.ProductResponse;
import com.example.liquorApp.entities.Products;


public interface ProductService {

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByCategory(String category);

    Products getProductById(Long id);

    Products createProduct(Products product);

    Products updateProduct(Long id, Products product);

    void deleteProduct(Long id);

    Products getProductBySKU(String productSKU);


}
