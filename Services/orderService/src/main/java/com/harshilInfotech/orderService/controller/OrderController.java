package com.harshilInfotech.orderService.controller;

import com.harshilInfotech.orderService.dto.OrderRequest;
import com.harshilInfotech.orderService.dto.OrderResponse;
import com.harshilInfotech.orderService.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(
            @RequestBody @Valid OrderRequest request
    ) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {

        return ResponseEntity.ok(orderService.findAll());

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findById(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

}