package com.example.liquorApp.dto.request;

import java.math.BigDecimal;

public record ProductUpdateRequest(
    Long id,
    String name,
    String brand,
    String category,
    String abvPercentage,
    BigDecimal price,
    String imageUrl,
    String productSKU
) {

}
