package com.ms.order.consumers;

import com.ms.order.models.dto.request.OrderRequestDTO;
import com.ms.order.models.entities.OrderEntity;
import com.ms.order.services.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload OrderRequestDTO orderDto) {
        OrderEntity order = new OrderEntity();
        BeanUtils.copyProperties(orderDto, order);
        orderService.findById(order.getId());
        orderService.create(new OrderRequestDTO());

    }
}
