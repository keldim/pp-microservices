package com.chrisyoo.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaProducer {
    @Value("${spring.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public String sendSkiResortsEvent() {
        UUID uuid = UUID.randomUUID();
        var completableFuture = kafkaTemplate.send(topic, uuid.toString());
        completableFuture
                .whenComplete((sendResult, throwable) -> {
                    if(throwable != null) {
                        handleFailure(throwable);
                    } else {
                        handleSuccess(uuid.toString(), sendResult);
                    }
                });
        return uuid.toString();
    }

    private void handleSuccess(String value, SendResult<String, String> sendResult) {
        log.info("Message successfully sent for the value : {}", value);
    }

    private void handleFailure(Throwable ex) {
        log.error("Error sending the message and the exception is {}", ex.getMessage(), ex);
    }
}