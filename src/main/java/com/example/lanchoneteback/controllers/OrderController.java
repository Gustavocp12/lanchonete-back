package com.example.lanchoneteback.controllers;

import com.example.lanchoneteback.domains.Order;
import com.example.lanchoneteback.dtos.OrderDto;
import com.example.lanchoneteback.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> registerOrder(@RequestBody OrderDto dto) {
        Order newOrder = orderService.registerOrder(dto);
        return ResponseEntity.ok(newOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }
}
