package com.chrisyoo.guest;

import org.springframework.stereotype.Service;

@Service
public record GuestService() {
    public void registerGuest(GuestRegistrationRequest request) {
        Guest guest = Guest.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
    }
}
