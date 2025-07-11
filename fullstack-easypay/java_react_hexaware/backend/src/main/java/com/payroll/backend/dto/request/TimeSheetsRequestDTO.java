package com.payroll.backend.dto.request;

import com.payroll.backend.enums.TimeSheetsStatus;
import java.time.LocalDate;

public class TimeSheetsRequestDTO {
    private Long employeeId;
    private LocalDate date;
    private double hoursWorked;
    private TimeSheetsStatus status;
	public TimeSheetsRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimeSheetsRequestDTO(Long employeeId, LocalDate date, double hoursWorked, TimeSheetsStatus status) {
		super();
		this.employeeId = employeeId;
		this.date = date;
		this.hoursWorked = hoursWorked;
		this.status = status;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public TimeSheetsStatus getStatus() {
		return status;
	}
	public void setStatus(TimeSheetsStatus status) {
		this.status = status;
	}

    
}
