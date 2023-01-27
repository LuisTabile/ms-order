package com.ms.order.services;

import com.ms.order.models.dto.request.ItemRequestDTO;
import com.ms.order.models.dto.response.ItemResponseDTO;
import com.ms.order.models.entities.ItemEntity;
import com.ms.order.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void testUpdate() {
        ItemRequestDTO requestDTO = new ItemRequestDTO();
        requestDTO.setName("item1");
        requestDTO.setPrice(10.0);
        requestDTO.setDescription("description1");
        requestDTO.setCreationTime(LocalDateTime.now());
        requestDTO.setValidationTime(LocalDateTime.now().plusDays(1));
        ItemEntity item = new ItemEntity();
        item.setId(1L);
        item.setName("item1");
        item.setPrice(10.0);
        item.setDescription("description1");
        item.setCreationTime(LocalDateTime.now());
        item.setValidationTime(LocalDateTime.now().plusDays(1));
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        when(modelMapper.map(item, ItemResponseDTO.class)).thenReturn(new ItemResponseDTO());
        itemService.update(1L, requestDTO);
        verify(itemRepository, times(1)).save(item);
    }
}