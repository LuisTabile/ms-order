package com.ms.order.controllers;

import com.ms.order.models.dto.request.OrderRequestDTO;
import com.ms.order.models.dto.request.OrderRequestUpdateDTO;
import com.ms.order.models.dto.response.OrderResponseDTO;
import com.ms.order.models.dto.response.OrderResponseParameters;
import com.ms.order.services.AddressService;
import com.ms.order.services.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pedidos")
public class OrderController {
    private final OrderServiceImpl orderService;
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@Valid @RequestBody OrderRequestDTO requestDTO) {
        OrderResponseDTO orderResponseDTO = orderService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDTO);
    }

    @GetMapping
    public ResponseEntity<OrderResponseParameters> findAll(@Valid @RequestBody String cpf, Pageable pageable) {
        OrderResponseParameters orderResponse = (OrderResponseParameters) orderService.findAll(cpf, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable("id") Long id){
        OrderResponseDTO orderResponseDTO = orderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> delete(@PathVariable("id") Long id){
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
