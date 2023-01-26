package com.ms.order.models.dto;

import com.ms.order.models.entities.AddressEntity;
import com.ms.order.models.entities.ItemEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class OrderDto {
    @NotBlank
    private Long orderId;
    @NotBlank
    private String cpf;
    @NotBlank
    private long amount;
    @NotBlank
    private List<ItemEntity> itemsList;
    @NotBlank
    private AddressEntity addressEntity;
}
