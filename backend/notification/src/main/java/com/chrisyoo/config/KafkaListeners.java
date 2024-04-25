package com.chrisyoo.config;

import com.chrisyoo.notification.NotificationService;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Component
public class KafkaListeners {
    @Autowired
    NotificationService notificationService;
    @KafkaListener(topics = "ski", groupId = "one")
    void listener(String uuid) {
        System.out.println("Listener received: " + uuid);

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
//            dataInJsonFormat = (JSONObject) parser.parse(body);
            notificationService.saveSkiResortList(body, uuid);
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
