package com.ms.history.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.ms.history.models.dtos.response.HistoryResponseDTO;
import com.ms.history.services.HistoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class HistoryControllerTest {
    private MockMvc mockMvc;

    @Mock
    private HistoryServiceImpl historyService;

    @InjectMocks
    private HistoryController historyController;

    @Test
    void testFindAll() throws Exception {
        LocalDateTime start = LocalDateTime.of(2020, 1, 1, 0, 0);
        LocalDateTime finish = LocalDateTime.of(2020, 1, 2, 0, 0);
        List<HistoryResponseDTO> history = Arrays.asList(new HistoryResponseDTO());
        when(historyService.findAll(any(LocalDateTime.class), any(LocalDateTime.class))).thenReturn(history);

        mockMvc = MockMvcBuilders.standaloneSetup(historyController).build();
        mockMvc.perform(get("/api/historico?start=" + start + "&finish=" + finish))
                .andExpect(status().isOk());

        ResponseEntity<List<HistoryResponseDTO>> response = historyController.findAll(start, finish);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(history, response.getBody());
    }
}