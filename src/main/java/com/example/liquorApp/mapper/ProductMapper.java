package com.example.liquorApp.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.liquorApp.dto.request.ProductCreateRequest;
import com.example.liquorApp.dto.response.ProductResponse;
import com.example.liquorApp.entities.Products;
@Component
public class ProductMapper {

    public Products toEntity(ProductCreateRequest request) {
        Products product = new Products();
        product.setName(request.name());
        product.setBrand(request.brand());
        product.setCategory(request.category()); // Assuming you have a constructor in Category that takes a name
        product.setAbvPercentage(new BigDecimal(request.abvPercentage()));
        product.setPrice(request.price());
        product.setImageUrl(request.imageUrl());
        product.setProductSKU(request.productSKU());
        return product;
    }

    public ProductCreateRequest toRequest(Products product) {
        ProductCreateRequest request = new ProductCreateRequest(
            product.getName(),
            product.getBrand(),
            product.getCategory(),
            product.getAbvPercentage().toString(),
            product.getPrice(),
            product.getImageUrl(),
            product.getProductSKU()
        );
        return request;
    }
     public ProductResponse toResponse(Products product) {
    return new ProductResponse(
        product.getId(),
        product.getName(),
        product.getBrand(),
        product.getCategory().name(),
        product.getAbvPercentage().toString(),
        product.getPrice(),
        product.getImageUrl()
    );
}
   
}
    