package com.example.liquorApp.service;

import com.example.liquorApp.repository.ProductRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.liquorApp.dto.request.ProductCreateRequest;
import com.example.liquorApp.dto.request.ProductUpdateRequest;
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
    public ProductResponse getProductById(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
        return productMapper.toResponse(product);
    }

    @Override 
    public ProductResponse createProduct(ProductCreateRequest productCreateRequest) {
        Products product = productMapper.toEntity(productCreateRequest);
        return productMapper.toResponse(productRepository.save(product));
    }


    @Override
    public Products updateProduct(Long id, ProductUpdateRequest productUpdateRequest) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
        Products product = productMapper.toEntity(productUpdateRequest);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductResponse getProductBySKU(String productSKU) {
        Products product = productRepository.findByProductSKU(productSKU)
                .orElseThrow(() -> new ResourceNotFoundException("Product with SKU " + productSKU + " not found"));
        return productMapper.toResponse(product);
    }

}
