package com.chrisyoo.notification;

import org.json.JSONObject;

public class NotificationService {
    NotificationRepository notificationRepository;

    public void saveSkiResortList(JSONObject skiResortList, String uuid) {
        Notification notification = new Notification();
        notification.setUuid(uuid);
        notification.setSkiApiData(skiResortList);
        notificationRepository.save(notification);
    }

    public Notification getData(String uuid) {
        Notification data = notificationRepository.findByUuid(uuid);
        return data;
    }
}