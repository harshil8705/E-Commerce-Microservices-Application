package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.client.CustomerClient;
import com.harshilInfotech.orderService.client.ProductClient;
import com.harshilInfotech.orderService.dto.*;
import com.harshilInfotech.orderService.exception.BusinessException;
import com.harshilInfotech.orderService.kafka.OrderProducer;
import com.harshilInfotech.orderService.mapper.OrderMapper;
import com.harshilInfotech.orderService.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final ProductClient productClient;
    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    @Override
    public Long createOrder(OrderRequest request) {

        // Check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create Order:: No Customer exists with provided Id:: " + request.customerId()));

        // Purchase the products --> Product-ms
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        // Persist Order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        // Persist Order-line
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // Start Payment process

        // Send the order confirmation --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Override
    public OrderResponse findById(Long orderId) {

        return orderRepository.findById(orderId)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No Order found with the provided Id: %d", orderId)));

    }
}