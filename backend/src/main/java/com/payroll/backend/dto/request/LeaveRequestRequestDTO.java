package com.payroll.backend.dto.request;

import com.payroll.backend.enums.LeaveStatus;
import java.time.LocalDate;

public class LeaveRequestRequestDTO {
    private Long employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private LeaveStatus status;
    private LocalDate submittedOn;
    private Long approvedBy;
	public LeaveRequestRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveRequestRequestDTO(Long employeeId, LocalDate fromDate, LocalDate toDate, String reason,
			LeaveStatus status, LocalDate submittedOn, Long approvedBy) {
		super();
		this.employeeId = employeeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
		this.submittedOn = submittedOn;
		this.approvedBy = approvedBy;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	public LocalDate getSubmittedOn() {
		return submittedOn;
	}
	public void setSubmittedOn(LocalDate submittedOn) {
		this.submittedOn = submittedOn;
	}
	public Long getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

    
}

