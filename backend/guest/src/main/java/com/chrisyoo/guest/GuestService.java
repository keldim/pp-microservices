package com.chrisyoo.guest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

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

    public void getSkiResorts() {
        kafkaTemplate.send("ski", "hello kafka :)");
    }
}
