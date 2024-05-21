package com.chrisyoo.kafka;

import com.chrisyoo.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SkiEventsConsumer {
    SkiApiService skiApiService;
    NotificationService notificationService;

    @Autowired
    public SkiEventsConsumer(SkiApiService skiApiService, NotificationService notificationService) {
        this.skiApiService = skiApiService;
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = {"ski"})
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {
        log.info("ConsumerRecord : {}", consumerRecord);
        String response = skiApiService.sendRequestToSkiApi();
        if(!response.equals("")) {
            notificationService.saveSkiResortList(response, consumerRecord.value());
        }
    }
}
