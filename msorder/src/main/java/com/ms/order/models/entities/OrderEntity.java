package com.ms.order.models.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private String cpf;

    @Column
    private long amount;

    @OneToMany
    @JoinColumn(name = "itemId")
    private List<ItemEntity> itemsList;

    @OneToOne
    @JoinColumn(name = "addressId")
    private AddressEntity addressEntity;
}