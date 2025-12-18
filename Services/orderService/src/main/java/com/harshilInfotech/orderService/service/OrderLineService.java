package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.dto.OrderLineRequest;
import com.harshilInfotech.orderService.dto.OrderLineResponse;

import java.util.List;

public interface OrderLineService {
    Long saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllById(Long orderId);

}