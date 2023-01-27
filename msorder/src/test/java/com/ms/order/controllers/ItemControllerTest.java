package com.ms.order.controllers;

import com.ms.order.models.dto.request.ItemRequestDTO;
import com.ms.order.models.dto.response.ItemResponseDTO;
import com.ms.order.services.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {

    @Mock
    private ItemServiceImpl itemService;

    @InjectMocks
    private ItemController itemController;

    @Test
    public void update_shouldReturnOk() {
        // Given
        Long id = 1L;
        ItemRequestDTO itemRequestDTO = new ItemRequestDTO();
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        when(itemService.update(id, itemRequestDTO)).thenReturn(itemResponseDTO);

        // When
        ResponseEntity<ItemResponseDTO> response = itemController.update(id, itemRequestDTO);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(itemResponseDTO, response.getBody());
    }
}