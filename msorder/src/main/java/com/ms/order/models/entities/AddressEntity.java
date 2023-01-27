package com.ms.order.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private int number;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String cep;
}