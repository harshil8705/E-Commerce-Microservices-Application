package com.harshilInfotech.notificationService.dto;

import com.harshilInfotech.notificationService.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerDto customer,
        List<ProductDto> products
) {
}