package com.ms.history.services;

import com.ms.history.models.dtos.response.HistoryResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface HistoryService {

    List<HistoryResponseDTO> findAll(LocalDateTime start, LocalDateTime finish);
}
