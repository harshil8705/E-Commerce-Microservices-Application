package com.harshilInfotech.notificationService.dto;

import java.math.BigDecimal;

public record ProductDto(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}