package com.chrisyoo.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
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
        kafkaTemplate.send("ski", uuid.toString());
        return uuid.toString();
    }
}
