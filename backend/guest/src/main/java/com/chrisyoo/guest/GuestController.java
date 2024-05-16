package com.chrisyoo.guest;

import com.chrisyoo.kafka.SkiEventProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private final SkiEventProducer skiEventProducer;
    private final GuestService guestService;

    @PostMapping
    public void registerGuest(@RequestBody GuestRegistrationRequest guestRegistrationRequest) {
        log.info("new guest registration {}", guestRegistrationRequest);
        guestService.registerGuest(guestRegistrationRequest);
    }

    @GetMapping
    public String getSkiResorts() {
        log.info("get a list of ski resorts");
        return skiEventProducer.sendSkiResortsEvent();
    }
}
