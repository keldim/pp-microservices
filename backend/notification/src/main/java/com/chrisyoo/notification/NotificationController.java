package com.chrisyoo.notification;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
@RequestMapping("api/v1/notifictions")
public class NotificationController {
    NotificationService notificationService;
    @GetMapping
    public ResponseEntity<JSONObject> getData(@RequestBody String uuid) {
        log.info("get the saved data using uuid");

        try {
            Notification savedData = notificationService.getData(uuid);
            return ResponseEntity.ok(savedData.getSkiApiData());
        } catch (EntityNotFoundException e) {
            System.out.println(e);
            return ResponseEntity.notFound().build();
        }
    }
}
