package com.klu.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.dto.OrderRequest;
import com.klu.entity.Order;
import com.klu.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController 
{

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) 
    {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestHeader("X-Authenticated-User") String username,@RequestBody OrderRequest request)
    {

        Order order = new Order(username,request.getProduct(),request.getQuantity(),request.getPrice(),"CREATED");

        return ResponseEntity.ok(orderRepository.save(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@RequestHeader("X-Authenticated-User") String username) 
    {

        return ResponseEntity.ok(orderRepository.findByUsername(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@RequestHeader("X-Authenticated-User") String username,@PathVariable Long id) 
    {

        return orderRepository.findById(id)
                .filter(order -> order.getUsername().equals(username))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}