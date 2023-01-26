package com.ms.order.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item")
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column (name = "name")
    private String name;

    @Column (name = "creationTime")
    private LocalDateTime creationTime;

    @Column (name = "validationTime")
    private LocalDateTime validationTime;

    @Column (name = "price")
    private double price;

    @Column (name = "description")
    private String description;

}
