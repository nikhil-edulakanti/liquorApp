package com.example.liquorApp.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
    Long id,
    String name,
    String brand,
    String category,
    String abvPercentage,
    BigDecimal price,
    String imageUrl
) {

}
