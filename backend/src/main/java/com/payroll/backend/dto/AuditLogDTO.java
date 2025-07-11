package com.payroll.backend.dto;

import java.time.LocalDateTime;

public class AuditLogDTO {

    private Long logId;
    private Long userId;
    private String userName; // Optional - helpful for displaying who did the action
    private String action;
    private LocalDateTime timestamp;
    private String details;

    public AuditLogDTO() {}

    public AuditLogDTO(Long logId, Long userId, String userName, String action, LocalDateTime timestamp, String details) {
        this.logId = logId;
        this.userId = userId;
        this.userName = userName;
        this.action = action;
        this.timestamp = timestamp;
        this.details = details;
    }

    // Getters and Setters

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

