package com.chrisyoo.guest;

import com.chrisyoo.kafka.SkiEventsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private SkiEventsProducer skiEventsProducer;
    private GuestService guestService;

    @Autowired
    public GuestController(SkiEventsProducer skiEventsProducer, GuestService guestService) {
        this.skiEventsProducer = skiEventsProducer;
        this.guestService = guestService;
    }

    @PostMapping
    public void registerGuest(@RequestBody GuestRegistrationRequest guestRegistrationRequest) {
        log.info("new guest registration {}", guestRegistrationRequest);
        guestService.registerGuest(guestRegistrationRequest);
    }

    @GetMapping
    public String getSkiResorts() {
        log.info("get a list of ski resorts");
        return skiEventsProducer.sendSkiResortsEvent();
    }
}
