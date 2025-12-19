package com.harshilInfotech.paymentService.mapper;

import com.harshilInfotech.paymentService.dto.PaymentRequest;
import com.harshilInfotech.paymentService.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request) {

        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();

    }
}