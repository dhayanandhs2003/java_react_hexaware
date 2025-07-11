package com.payroll.backend.dto.request;

import java.time.LocalDateTime;

public class AuditLogRequestDTO {
    private Long userId;
    private String action;
    private LocalDateTime timestamp;
    private String details;
	public AuditLogRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuditLogRequestDTO(Long userId, String action, LocalDateTime timestamp, String details) {
		super();
		this.userId = userId;
		this.action = action;
		this.timestamp = timestamp;
		this.details = details;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
