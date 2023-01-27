package com.ms.history.models.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryEntity {
    @Id
    private String id;
    private Long orderId;
    private double orderPrice;
    private LocalDateTime orderDate;
}
