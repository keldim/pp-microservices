package com.chrisyoo.kafka;

import com.chrisyoo.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@Slf4j
public class SkiEventsConsumer {

    NotificationService notificationService;

    @Autowired
    public SkiEventsConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = {"ski"})
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {
        log.info("ConsumerRecord : {}", consumerRecord);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ski-resorts-and-conditions.p.rapidapi.com/v1/resort"))
                .header("X-RapidAPI-Key", "0495933f5emsh19af863bbc666d5p1290dbjsn0dd243175962")
                .header("X-RapidAPI-Host", "ski-resorts-and-conditions.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        String body = "";
        JSONParser parser = new JSONParser();
        JSONObject dataInJsonFormat = null;
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            body = response.body();
            notificationService.saveSkiResortList(body, consumerRecord.value());
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
