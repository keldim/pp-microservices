package com.chrisyoo.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findByUuid(String uuid);
}
