package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.client.CustomerClient;
import com.harshilInfotech.orderService.dto.OrderRequest;
import com.harshilInfotech.orderService.exception.BusinessException;
import com.harshilInfotech.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    @Override
    public Integer createOrder(OrderRequest request) {

        // Check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create Order:: No Customer exists with provided Id:: " + request.customerId()));

        // Purchase the products --> Product-ms

        // Persist Order

        // Persist Order-line

        // Start Payment process

        // Send the order confirmation --> notification-ms (kafka)
        return 0;
    }
}