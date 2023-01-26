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

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "amount")
    private long amount;

    @OneToMany
    @JoinColumn(name = "itemId")
    private List<ItemEntity> itemsList;

    @JoinColumn(name = "addressId")
    @OneToOne
    private AddressEntity addressEntity;
}
