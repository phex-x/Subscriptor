package com.subscriptor.repository;

import com.subscriptor.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
