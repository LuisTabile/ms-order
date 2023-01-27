package com.ms.history.consumers;

import com.ms.history.models.dtos.response.HistoryResponseDTO;
import com.ms.history.models.entities.HistoryEntity;
import com.ms.history.services.HistoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HistoryConsumer {
    @Autowired
    HistoryService historyService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload HistoryResponseDTO responseDTO) {
        HistoryEntity history = new HistoryEntity();
        BeanUtils.copyProperties(responseDTO, history);
    }
}

