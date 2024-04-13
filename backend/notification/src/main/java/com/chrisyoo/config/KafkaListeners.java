package com.chrisyoo.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "ski", groupId = "one")
    void listener(String data) {
        System.out.println("Listener received: " + data);
        String url = "";
        RestTemplate restTemplate = new RestTemplate();
        Object[] skiResortList = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(skiResortList);
    }
}
