package com.ms.history.controllers;

import com.ms.history.models.dtos.response.HistoryResponseDTO;
import com.ms.history.services.HistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/historico")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryServiceImpl historyService;

    @GetMapping
    public ResponseEntity findAll(LocalDateTime start, LocalDateTime finish) {
        List<HistoryResponseDTO> history = historyService.findAll(start, finish);
        return ResponseEntity.status(HttpStatus.OK).body(history);
    }
}
