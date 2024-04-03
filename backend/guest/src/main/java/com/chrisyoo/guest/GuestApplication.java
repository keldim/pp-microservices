package com.chrisyoo.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.chrisyoo.guest",
                "com.chrisyoo.kafka"
        }
)
public class GuestApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuestApplication.class, args);
    }
}
