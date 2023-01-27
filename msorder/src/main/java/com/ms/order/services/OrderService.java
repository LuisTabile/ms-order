package com.ms.order.services;

import com.ms.order.models.dto.request.OrderRequestDTO;
import com.ms.order.models.dto.request.OrderRequestUpdateDTO;
import com.ms.order.models.dto.response.OrderResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface OrderService {
    OrderResponseDTO create(OrderRequestDTO request);

    Page<OrderResponseDTO> findAll(String cpf, org.springframework.data.domain.Pageable pageable);

    OrderResponseDTO findById(Long id);
    void delete(Long id);
}