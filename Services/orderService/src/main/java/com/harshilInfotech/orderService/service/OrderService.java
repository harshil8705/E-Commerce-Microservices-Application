package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.dto.OrderRequest;
import jakarta.validation.Valid;

public interface OrderService {

    Integer createOrder(@Valid OrderRequest request);

}