package com.harshilInfotech.orderService.dto;

import com.harshilInfotech.orderService.enums.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
    Long id,
    String reference,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerId
) {
}