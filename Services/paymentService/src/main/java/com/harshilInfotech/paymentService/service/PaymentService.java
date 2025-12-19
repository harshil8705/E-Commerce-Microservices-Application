package com.harshilInfotech.paymentService.service;

import com.harshilInfotech.paymentService.dto.PaymentRequest;
import jakarta.validation.Valid;

public interface PaymentService {

    Long createPayment(@Valid PaymentRequest request);

}