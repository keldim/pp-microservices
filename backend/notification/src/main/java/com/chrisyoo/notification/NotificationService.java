package com.chrisyoo.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    public void saveSkiResortList(String skiResortList, String uuid) {
        Notification notification = new Notification();
        notification.setUuid(uuid);
        notification.setSkiApiData(skiResortList);
        notificationRepository.save(notification);
    }

    public Notification getData(String uuid) {
        return notificationRepository.findByUuid(uuid).orElseThrow();
    }
}