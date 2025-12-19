package com.harshilInfotech.paymentService.dto;

import com.harshilInfotech.paymentService.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Long id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        CustomerDto customer
) {
}