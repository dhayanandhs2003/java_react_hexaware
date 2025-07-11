package com.payroll.backend.dto;

import java.time.LocalDateTime;

import com.payroll.backend.enums.NotificationStatus;
import com.payroll.backend.enums.NotificationType;

public class NotificationDTO {

    private Long notificationId;
    private Long userId;
    private String userName;  // Optional for display
    private String message;
    private NotificationType type;
    private NotificationStatus status;
    private LocalDateTime createdOn;

    public NotificationDTO() {}

    public NotificationDTO(Long notificationId, Long userId, String userName, String message,
                           NotificationType type, NotificationStatus status, LocalDateTime createdOn) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.userName = userName;
        this.message = message;
        this.type = type;
        this.status = status;
        this.createdOn = createdOn;
    }

    // Getters and Setters

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}

