package com.ms.order.repository;

import com.ms.order.models.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {



}
