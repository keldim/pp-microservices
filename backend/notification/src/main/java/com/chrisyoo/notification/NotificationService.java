package com.chrisyoo.notification;

import org.json.JSONObject;

public class NotificationService {
    NotificationRepository notificationRepository;
    public void sendSkiResortList(Object[] skiResortList) {
        // send it to ski api
        // but with the sender as guest
        // or create an endpoint in guest that simply receives list

        // save the kafka message id as uuid in notification database
        // in the guest controller, send back the uuid right away after the
        // kafka message is sent
    }

    public void saveSkiResortList(JSONObject skiResortList, String uuid) {
        Notification notification = new Notification();
        notification.setUuid(uuid);
        notification.setSkiApiData(skiResortList);
        notificationRepository.save(notification);
    }
}