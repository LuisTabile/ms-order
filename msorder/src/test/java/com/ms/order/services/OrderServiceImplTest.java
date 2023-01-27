package com.ms.order.services;

import com.ms.order.models.dto.request.OrderRequestDTO;
import com.ms.order.models.dto.response.OrderResponseDTO;
import com.ms.order.models.entities.OrderEntity;
import com.ms.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @Mock
    private OrderRepository itemRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testCreateOrder() {
        // Arrange
        OrderRequestDTO request = new OrderRequestDTO();
        request.setCpf("12345678910");
        // Act
        OrderResponseDTO result = orderService.create(request);
        // Assert
        assertEquals(request.getCpf(), result.getCpf());
        assertNotNull(result.getId());
    }
}