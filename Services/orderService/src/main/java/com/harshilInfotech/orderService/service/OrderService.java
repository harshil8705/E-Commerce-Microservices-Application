package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.dto.OrderRequest;
import com.harshilInfotech.orderService.dto.OrderResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderService {

    Long createOrder(@Valid OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Long orderId);

}