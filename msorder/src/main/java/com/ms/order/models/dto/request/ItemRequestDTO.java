package com.ms.order.models.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ItemRequestDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private LocalDateTime creationTime;

    @NotNull
    private LocalDateTime validationTime;

    @NotNull
    @Range(min = 0)
    private double price;

    @NotBlank
    @Size(max = 200)
    private String description;
}
