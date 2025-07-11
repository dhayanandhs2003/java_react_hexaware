package com.payroll.backend.entity;

import com.payroll.backend.enums.LeaveStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    // Many leave requests belong to one employee
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

    private LocalDate fromDate;
    private LocalDate toDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status = LeaveStatus.PENDING;

    private LocalDate submittedOn;

    // Optional: Manager who approved the request
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employees approvedBy;  // This refers to the manager/supervisor

	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveRequest(Long leaveId, Employees employee, LocalDate fromDate, LocalDate toDate, String reason,
			LeaveStatus status, LocalDate submittedOn, Employees approvedBy) {
		super();
		this.leaveId = leaveId;
		this.employee = employee;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
		this.submittedOn = submittedOn;
		this.approvedBy = approvedBy;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
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

	public Employees getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Employees approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Override
	public String toString() {
		return "LeaveRequest [leaveId=" + leaveId + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", reason=" + reason + ", status=" + status + ", submittedOn=" + submittedOn
				+ ", approvedBy=" + approvedBy + "]";
	}
    
}