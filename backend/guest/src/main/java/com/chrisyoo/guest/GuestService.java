package com.chrisyoo.guest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GuestService {
    GuestRepository guestRepository;
    KafkaTemplate<String, String> kafkaTemplate;
    public void registerGuest(GuestRegistrationRequest request) {
        Guest guest = Guest.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        guestRepository.save(guest);
    }

    public String getSkiResorts() {
        UUID uuid = UUID.randomUUID();
        kafkaTemplate.send("ski", "get a list of ski resorts");
        return uuid.toString();
    }
}
