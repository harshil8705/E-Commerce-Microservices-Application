package com.harshilInfotech.orderService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(

        @NotNull(message = "Product is mandatary")
        Long productId,

        @Positive(message = "Quantity is mandatary and should be Positive")
        Double quantity
) {
}