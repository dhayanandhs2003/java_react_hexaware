package com.payroll.backend.entity;

import com.payroll.backend.enums.NotificationStatus;
import com.payroll.backend.enums.NotificationType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status = NotificationStatus.UNREAD;

    private LocalDateTime createdOn;

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Long notificationId, Users user, String message, NotificationType type,
			NotificationStatus status, LocalDateTime createdOn) {
		super();
		this.notificationId = notificationId;
		this.user = user;
		this.message = message;
		this.type = type;
		this.status = status;
		this.createdOn = createdOn;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", message=" + message + ", type="
				+ type + ", status=" + status + ", createdOn=" + createdOn + "]";
	}
    
}