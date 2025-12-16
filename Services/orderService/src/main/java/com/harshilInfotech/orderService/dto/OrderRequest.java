package com.harshilInfotech.orderService.dto;

import com.harshilInfotech.orderService.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
    Long id,
    String reference,

    @Positive(message = "Order should be positive")
    BigDecimal amount,

    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod,

    @NotNull(message = "Customer should be Present")
    @NotEmpty(message = "Customer should be Present")
    @NotBlank(message = "Customer should be Present")
    String customerId,

    @NotEmpty(message = "You should at least purchase One Product")
    List<PurchaseRequest> products
) {
}