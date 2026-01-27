package com.subscriptor.mapper;

import com.subscriptor.dto.notification.NotificationCreateRequest;
import com.subscriptor.dto.notification.NotificationResponse;
import com.subscriptor.entity.notification.Notification;
import com.subscriptor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public Notification toEntity(NotificationCreateRequest notificationCreateRequest) {
        Notification notification = new Notification();
        notification.setUser(userRepository.findById(notificationCreateRequest.getUserId())
                .orElseThrow((() -> new BadCredentialsException("User not found"))));
        notification.setType(notificationCreateRequest.getType());
        notification.setPayload(notificationCreateRequest.getPayload());

        return notification;
    }

    public NotificationResponse toResponse(Notification notification) {
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setId(notification.getId());
        notificationResponse.setUser(userMapper.toResponse(notification.getUser()));
        notificationResponse.setPayload(notification.getPayload());
        notificationResponse.setType(notification.getType());
        notificationResponse.setStatus(notification.getStatus());
        notificationResponse.setRetryCount(notification.getRetryCount());
        notificationResponse.setCreatedAt(notification.getCreatedAt());

        return notificationResponse;
    }
}
