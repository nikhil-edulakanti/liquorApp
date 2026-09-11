package com.example.liquorApp.controller;

import com.example.liquorApp.service.ProductService;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.liquorApp.dto.request.ProductCreateRequest;
import com.example.liquorApp.dto.request.ProductUpdateRequest;
import com.example.liquorApp.dto.response.ProductResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




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

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/products/new")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest productCreateRequest){
        return ResponseEntity.ok(productService.createProduct(productCreateRequest));
    }

    @PutMapping("/products/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequest productUpdateRequest){
        return ResponseEntity.ok(productService.updateProduct(id, productUpdateRequest));
}
    @DeleteMapping ("/products/delete/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted");
    }

    @GetMapping("product/{sku}")
    public ResponseEntity<ProductResponse> getProductbySKU(@PathVariable String sku) {
        return ResponseEntity.ok(productService.getProductBySKU(sku));
    }
    
}
