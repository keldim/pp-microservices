package com.chrisyoo.guest;

public record GuestRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {

}
