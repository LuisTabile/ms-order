package com.ms.history.services;

import com.ms.history.models.dtos.response.HistoryResponseDTO;
import com.ms.history.models.entities.HistoryEntity;
import com.ms.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final ModelMapper modelMapper;
    private final HistoryRepository historyRepository;

    public List<HistoryResponseDTO> findAll(LocalDateTime start, LocalDateTime finish) {
        List<HistoryEntity> list = historyRepository.findAll(Sort.by("orderDate").descending());
        return mapListToDTO(list);
    }
    private List<HistoryResponseDTO> mapListToDTO(List<HistoryEntity> historyEntityList) {
        return historyEntityList.stream().map(historyEntity -> modelMapper.map(historyEntity, HistoryResponseDTO.class)).collect(Collectors.toList());
    }
}