package com.ms.order.controllers;

import com.ms.order.models.dto.response.OrderResponseDTO;
import com.ms.order.models.dto.response.OrderResponseParameters;
import com.ms.order.services.AddressService;
import com.ms.order.services.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderServiceImpl orderService;
    @MockBean
    private AddressService addressService;
    private Page<OrderResponseDTO> OrderResponseParameters;


    @Test
    public void testFindAll() throws Exception {
        String cpf = "123456";
        Pageable pageable = PageRequest.of(0, 10);
        OrderResponseParameters response = new OrderResponseParameters();
        when(orderService.findAll(any(), any())).thenReturn(OrderResponseParameters);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos").param("cpf", cpf).param("page", "0").param("size", "10")).andExpect(status().isOk());

        verify(orderService, times(1)).findAll(cpf, pageable);
    }

    @Test
    public void testFindById() throws Exception {
        Long id = 1L;
        OrderResponseDTO responseDTO = new OrderResponseDTO();

        when(orderService.findById(id)).thenReturn(responseDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos/{id}", id)).andExpect(status().isOk());

        verify(orderService, times(1)).findById(id);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/pedidos/{id}", id)).andExpect(status().isNoContent());

        verify(orderService, times(1)).delete(id);
    }
}


