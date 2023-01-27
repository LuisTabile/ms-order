package com.ms.history.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponseDTO {
    private String id;
    private Long orderId;
    private double orderPrice;
    private LocalDateTime orderDate;
}
