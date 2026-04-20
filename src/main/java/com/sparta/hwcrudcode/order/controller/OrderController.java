package com.sparta.hwcrudcode.order.controller;

import com.sparta.hwcrudcode.order.dto.OrderRequest;
import com.sparta.hwcrudcode.order.dto.OrderResponse;
import com.sparta.hwcrudcode.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        OrderResponse response = orderService.createProduct(request);
        return ResponseEntity.created(URI.create("/api/orders/" + response.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}

