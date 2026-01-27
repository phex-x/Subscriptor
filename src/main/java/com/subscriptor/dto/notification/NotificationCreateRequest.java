package com.subscriptor.dto.notification;

import com.subscriptor.entity.notification.NotificationType;

public class NotificationCreateRequest {
    private Long userId;
    private NotificationType type;
    private String payload;

    //getters
    public Long getUserId() { return userId; }
    public NotificationType getType() { return type; }
    public String getPayload() { return payload; }

    //setters
    public void setUserId(Long userId) { this.userId = userId; }
    public void setType(NotificationType type) { this.type = type; }
    public void setPayload(String payload) { this.payload = payload; }
}
