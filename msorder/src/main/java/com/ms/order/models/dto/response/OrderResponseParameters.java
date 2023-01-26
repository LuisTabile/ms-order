package com.ms.order.models.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class OrderResponseParameters {
    private Integer numberOfElements;
    private Long totalElements;
    private Integer totalPages;
    private List<OrderResponseDTO> order;
}

