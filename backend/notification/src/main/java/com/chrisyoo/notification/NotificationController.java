package com.chrisyoo.notification;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @GetMapping
    public ResponseEntity<String> getData(HttpServletRequest request) {
        log.info("get the saved data using uuid: " + request.getHeader("uuid"));

        try {
            Notification savedData = notificationService.getData(request.getHeader("uuid"));
            return ResponseEntity.ok(savedData.getSkiApiData());
        } catch (EntityNotFoundException e) {
            System.out.println(e);
            return ResponseEntity.notFound().build();
        }
    }
}
