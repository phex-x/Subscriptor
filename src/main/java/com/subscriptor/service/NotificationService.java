package com.subscriptor.service;

import com.subscriptor.dto.notification.NotificationCreateRequest;
import com.subscriptor.dto.notification.NotificationResponse;
import com.subscriptor.entity.notification.Notification;
import com.subscriptor.entity.notification.NotificationStatus;
import com.subscriptor.mapper.NotificationMapper;
import com.subscriptor.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    public NotificationResponse createNotification(NotificationCreateRequest notificationCreateRequest) {
        Notification notification = notificationMapper.toEntity(notificationCreateRequest);
        notification = notificationRepository.save(notification);

        return notificationMapper.toResponse(notification);
    }

    public NotificationResponse getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Notification not found"));

        return notificationMapper.toResponse(notification);
    }

    public NotificationResponse changeStatus(Long id, NotificationStatus status) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Notification not found"));
        notification.setStatus(status);
        notification = notificationRepository.save(notification);

        return notificationMapper.toResponse(notification);
    }

    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Notification not found"));

        notificationRepository.delete(notification);
    }
}
