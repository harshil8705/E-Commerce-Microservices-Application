package com.harshilInfotech.orderService.client;

import com.harshilInfotech.orderService.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "product-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequest request);

}