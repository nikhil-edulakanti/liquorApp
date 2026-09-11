package com.example.liquorApp.dto.request;

import java.math.BigDecimal;

import com.example.liquorApp.entities.Category;

public record ProductUpdateRequest(
    Long id,
    String name,
    String brand,
    Category category,
    String abvPercentage,
    BigDecimal price,
    String imageUrl,
    String productSKU
) {

}
