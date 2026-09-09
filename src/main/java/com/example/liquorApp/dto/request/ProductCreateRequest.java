package com.example.liquorApp.dto.request;

import java.math.BigDecimal;

import com.example.liquorApp.entities.Category;

import jakarta.validation.constraints.NotBlank;

public record ProductCreateRequest(

    @NotBlank
    String name,
    @NotBlank
    String brand,
    @NotBlank
    Category category,
    @NotBlank
    String abvPercentage,
    @NotBlank
    BigDecimal price,
   
    String imageUrl,
    @NotBlank
    String productSKU
){

}
