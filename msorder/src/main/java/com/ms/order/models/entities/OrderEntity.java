package com.ms.order.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String cpf;
    private long amount;
    private List<ItemEntity> itemsList;

    @JoinColumn(name = "address.id")
    @OneToOne
    private AddressEntity addressEntity;
}
