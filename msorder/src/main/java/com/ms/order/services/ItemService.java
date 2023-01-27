package com.ms.order.services;

import com.ms.order.models.dto.request.ItemRequestDTO;
import com.ms.order.models.dto.response.ItemResponseDTO;
import com.ms.order.models.entities.ItemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    void create(List<ItemEntity> items);
    ItemResponseDTO update(Long itemId, ItemRequestDTO requestDTO);
}
