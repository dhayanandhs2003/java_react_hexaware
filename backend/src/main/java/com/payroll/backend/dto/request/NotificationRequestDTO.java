package com.payroll.backend.dto.request;

import com.payroll.backend.enums.NotificationStatus;
import com.payroll.backend.enums.NotificationType;
import java.time.LocalDateTime;

public class NotificationRequestDTO {
    private Long userId;
    private String message;
    private NotificationType type;
    private NotificationStatus status;
    private LocalDateTime createdOn;
	public NotificationRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotificationRequestDTO(Long userId, String message, NotificationType type, NotificationStatus status,
			LocalDateTime createdOn) {
		super();
		this.userId = userId;
		this.message = message;
		this.type = type;
		this.status = status;
		this.createdOn = createdOn;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
