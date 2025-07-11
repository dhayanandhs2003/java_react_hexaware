package com.payroll.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String action;

    private LocalDateTime timestamp;

    private String details;

	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditLog(Long logId, Users user, String action, LocalDateTime timestamp, String details) {
		super();
		this.logId = logId;
		this.user = user;
		this.action = action;
		this.timestamp = timestamp;
		this.details = details;
	}

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "AuditLog [logId=" + logId + ", action=" + action + ", timestamp=" + timestamp
				+ ", details=" + details + "]";
	}
    
}
