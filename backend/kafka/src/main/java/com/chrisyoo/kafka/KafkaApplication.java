package com.chrisyoo.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("ski", "hello kafka");
//        };
//    }

    @KafkaListener(topics = "ski", groupId = "list")
    void listener(String uuid) {
        System.out.println("Listener received: " + uuid);
    }
}
