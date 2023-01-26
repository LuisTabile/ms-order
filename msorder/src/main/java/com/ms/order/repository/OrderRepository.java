package com.ms.order.repository;

import com.ms.order.models.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Page<OrderEntity> findByCpf(String cpf, Pageable pageable);

    Page<OrderEntity> findAll(Pageable pageable);

}
//The interface defines two methods that return a Page of OrderEntity:
//findByCpf: it will take a cpf number as parameter and returns a Page of OrderEntity
//findAll: it will take a Pageable object as parameter and returns a Page of OrderEntity