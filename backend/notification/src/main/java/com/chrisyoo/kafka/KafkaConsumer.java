package com.chrisyoo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
//    @Autowired
//    NotificationService notificationService;

    @KafkaListener(topics = {"ski"})
    void listener(ConsumerRecord<String, String> consumerRecord) {
        log.info("ConsumerRecord : {}", consumerRecord);

// String uuid
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://ski-resorts-and-conditions.p.rapidapi.com/v1/resort"))
//                .header("X-RapidAPI-Key", "0495933f5emsh19af863bbc666d5p1290dbjsn0dd243175962")
//                .header("X-RapidAPI-Host", "ski-resorts-and-conditions.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//
//        String body = "";
//        JSONParser parser = new JSONParser();
//        JSONObject dataInJsonFormat = null;
//        try {
//            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//            body = response.body();
//            notificationService.saveSkiResortList(body, uuid);
//        } catch(Exception exception) {
//            System.out.println(exception);
//        }
    }
}
