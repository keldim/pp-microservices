package com.chrisyoo.guest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {

    GuestService guestService;

    @PostMapping
    public void registerGuest(@RequestBody GuestRegistrationRequest guestRegistrationRequest) {
        log.info("new guest registration {}", guestRegistrationRequest);
        guestService.registerGuest(guestRegistrationRequest);
    }

    @GetMapping
    public String getSkiResorts() {
        log.info("get a list of ski resorts");
        return guestService.getSkiResorts();
    }
}
