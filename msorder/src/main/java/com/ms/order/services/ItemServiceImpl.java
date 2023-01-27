package com.ms.order.services;

import com.ms.order.exceptions.ItemNotFoundException;
import com.ms.order.models.dto.request.ItemRequestDTO;
import com.ms.order.models.dto.response.ItemResponseDTO;
import com.ms.order.models.entities.ItemEntity;
import com.ms.order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;


    public ItemResponseDTO update(Long id, ItemRequestDTO requestDTO) {
        ItemEntity itemToUpdate = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item with id " + id + " not found"));

        itemToUpdate.setName(requestDTO.getName());
        itemToUpdate.setPrice(requestDTO.getPrice());
        itemToUpdate.setDescription(requestDTO.getDescription());
        itemToUpdate.setCreationTime(requestDTO.getCreationTime());
        itemToUpdate.setValidationTime(requestDTO.getValidationTime());

        itemRepository.save(itemToUpdate);
        return modelMapper.map(itemToUpdate, ItemResponseDTO.class);
    }

    @Override
    public void create(List<ItemEntity> items) {
        items.forEach(itemRepository::save);
    }

    public ItemEntity findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }
    public List<ItemEntity> findAll(){
        return itemRepository.findAll();
    }
}
