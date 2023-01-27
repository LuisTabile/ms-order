package com.ms.order.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseParameters {
    private Integer numberOfElements;
    private Long totalElements;
    private Integer totalPages;
    private List<OrderResponseDTO> orders;
}

