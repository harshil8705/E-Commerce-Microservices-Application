package com.harshilInfotech.orderService.controller;

import com.harshilInfotech.orderService.dto.OrderLineResponse;
import com.harshilInfotech.orderService.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderLineResponse>> findAllByOrderId(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(orderLineService.findAllById(orderId));
    }

}