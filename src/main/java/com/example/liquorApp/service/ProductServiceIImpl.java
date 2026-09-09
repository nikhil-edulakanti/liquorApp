package com.example.liquorApp.service;

import com.example.liquorApp.repository.ProductRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.liquorApp.dto.response.ProductResponse;
import com.example.liquorApp.entities.Products;
import com.example.liquorApp.mapper.ProductMapper;
import com.example.liquorApp.exceptions.ResourceNotFoundException;


@Service
public class ProductServiceIImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    

    public ProductServiceIImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper=productMapper;
    }

    

    @Override
    public List<ProductResponse> getAllProducts() {
       List<Products> products = productRepository.findAll();
       if(products!=null && !products.isEmpty()){
            return products.stream().map(productMapper::toResponse).toList();
       }
       throw new ResourceNotFoundException("Resource not available");
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        List<Products> products = productRepository.findByCategory(category);
        if(products!=null && !products.isEmpty()){
            return products.stream().map(productMapper::toResponse).toList();
        }
        throw new ResourceNotFoundException("Category " + category + " not found");
    }

    @Override
    public Products getProductById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public Products createProduct(Products product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public Products updateProduct(Long id, Products product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Products getProductBySKU(String productSKU) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductBySKU'");
    }

    // Implement the methods defined in the ProductService interface

}
