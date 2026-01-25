package com.subscriptor.dto.notification;

import com.subscriptor.dto.user.UserResponse;
import com.subscriptor.entity.notification.NotificationStatus;
import com.subscriptor.entity.notification.NotificationType;

import java.time.LocalDateTime;

public class NotificationResponse {
    private Long id;
    private UserResponse user;
    private NotificationType type;
    private String payload;
    private NotificationStatus status;
    private int retryCount;
    private LocalDateTime createdAt;

    //getters
    public Long getId() { return id; }
    public UserResponse getUser() { return user; }
    public NotificationType getType() { return type; }
    public String getPayload() { return payload; }
    public NotificationStatus getStatus() { return status; }
    public int getRetryCount() { return retryCount; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    //setters
    public void setId(Long id) { this.id = id; }
    public void setUser(UserResponse user) { this.user = user; }
    public void setType(NotificationType type) { this.type = type; }
    public void setPayload(String payload) { this.payload = payload; }
    public void setStatus(NotificationStatus status) { this.status = status; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
