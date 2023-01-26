package com.ms.order.models.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ItemResponseDTO {
    private Long itemId;
    private String name;
    private LocalDateTime creationTime;
    private LocalDateTime validationTime;
    private double price;
    private String description;
}