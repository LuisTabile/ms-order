package com.ms.order.models.dto.response;

import com.ms.order.models.entities.AddressEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private String cpf;
    private List<ItemResponseDTO> items;
    private double amount;
    private AddressEntity address;
}
