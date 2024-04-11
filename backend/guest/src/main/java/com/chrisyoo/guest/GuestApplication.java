package com.chrisyoo.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuestApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuestApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("ski", "hello kafka :)");
//        };
//    }

//    (
//    scanBasePackages = {
//        "com.chrisyoo.guest",
//                "com.chrisyoo.kafka"
//    }
//)
}
