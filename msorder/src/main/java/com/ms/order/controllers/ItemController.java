package com.ms.order.controllers;

import com.ms.order.models.dto.request.ItemRequestDTO;
import com.ms.order.models.dto.response.ItemResponseDTO;
import com.ms.order.services.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/itens")
public class ItemController {
    private final ItemServiceImpl itemService;

    @PatchMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<ItemResponseDTO> update(@PathVariable("id") Long id, @Valid @RequestBody ItemRequestDTO itemRequestDTO) {
        ItemResponseDTO responseDTO = itemService.update(id, itemRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
