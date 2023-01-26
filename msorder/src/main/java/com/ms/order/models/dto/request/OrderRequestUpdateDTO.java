package com.ms.order.models.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OrderRequestUpdateDTO {

    @CPF
    private String cpf;

    @NotBlank
    @Length(min = 8, max = 9)
    private String cep;

    @NotNull
    private Long number;
}