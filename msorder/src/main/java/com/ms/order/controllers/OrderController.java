package com.ms.order.controllers;

import com.ms.order.models.dto.OrderDto;
import com.ms.order.models.entities.OrderEntity;
import com.ms.order.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping(value = "/api/pedidos/")
    public ResponseEntity<OrderDto> create(@RequestBody @Valid OrderDto request){
        OrderDto request = orderService.create(request);
    }
}
