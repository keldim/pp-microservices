package com.chrisyoo.guest;

import com.chrisyoo.kafka.SkiEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private SkiEventProducer skiEventProducer;
    private GuestService guestService;

    @Autowired
    public GuestController(SkiEventProducer skiEventProducer, GuestService guestService) {
        this.skiEventProducer = skiEventProducer;
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
        return skiEventProducer.sendSkiResortsEvent();
    }
}
