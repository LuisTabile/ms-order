package com.ms.order.services;

import com.ms.order.exceptions.OrderNotFoundException;
import com.ms.order.models.dto.request.OrderRequestDTO;
import com.ms.order.models.dto.response.OrderResponseDTO;
import com.ms.order.models.dto.response.OrderResponseParameters;
import com.ms.order.models.entities.OrderEntity;
import com.ms.order.repository.AddressRepository;
import com.ms.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final ItemServiceImpl itemService;
    private final AddressService addressService;
    private final ModelMapper modelMapper;


    @Override
    public OrderResponseDTO create(OrderRequestDTO request) {
        OrderEntity orderToCreate = new OrderEntity();
        itemService.create(request.getItems());
        orderToCreate.setItemsList(request.getItems());
        orderToCreate.setCpf(request.getCpf());
        OrderEntity orderCreated = orderRepository.save(orderToCreate);
        return modelMapper.map(orderCreated, OrderResponseDTO.class);
    }


   @Override
    public Page<OrderResponseDTO> findAll(String cpf, Pageable pageable) {
       Page<OrderEntity> page = cpf == null ?
                orderRepository.findAll(pageable) :
                orderRepository.findByCpf(cpf, pageable);

       return (Page<OrderResponseDTO>) createOrderResponseParameters(page);

    }

    @Override
    public OrderResponseDTO findById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return modelMapper.map(order, OrderResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    private OrderResponseParameters createOrderResponseParameters(Page<OrderEntity> page) {
        List<OrderResponseDTO> order = page.stream().map(this::createOrderResponseDto).collect(Collectors.toList());
        return OrderResponseParameters.builder().numberOfElements(page.getNumberOfElements()).totalElements(page.getTotalElements()).totalPages(page.getTotalPages()).orders(order).build();
    }

    public OrderResponseDTO createOrderResponseDto(OrderEntity order) {
        return modelMapper.map(order, OrderResponseDTO.class);
    }
}