package com.ms.order.models.dto.request;

import com.ms.order.models.entities.ItemEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderRequestDTO {

    @NotBlank
    @CPF(message = "CPF é inválido")
    private String cpf;

    @NotNull
    private List<ItemEntity> items;

    @NotNull
    @Range(min = 0)
    private double amount;

    @NotBlank
    @Length(min = 8, max = 9)
    //Can be 00000000
    //or 00000-000
    private String cep;

    @NotNull
    private Long number;
}