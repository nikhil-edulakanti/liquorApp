package com.example.liquorApp.service;
import java.util.List;

import com.example.liquorApp.dto.request.ProductCreateRequest;
import com.example.liquorApp.dto.request.ProductUpdateRequest;
import com.example.liquorApp.dto.response.ProductResponse;



public interface ProductService {

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByCategory(String category);

    ProductResponse getProductById(Long id);

    ProductResponse createProduct(ProductCreateRequest productCreateRequest);

    ProductResponse updateProduct(Long id, ProductUpdateRequest productUpdateRequest);

    void deleteProduct(Long id);

    ProductResponse getProductBySKU(String productSKU);


}
