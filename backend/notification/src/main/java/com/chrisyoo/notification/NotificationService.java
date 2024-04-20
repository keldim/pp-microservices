package com.chrisyoo.notification;

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
}