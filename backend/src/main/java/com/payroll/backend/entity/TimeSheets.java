package com.payroll.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.payroll.backend.enums.TimeSheetsStatus;

@Entity
@Table(name = "timesheets")
public class TimeSheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeSheetId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employees;

    private LocalDate date;
    private double hoursWorked;

    @Enumerated(EnumType.STRING)
    private TimeSheetsStatus status; // PENDING, APPROVED, REJECTED (enum)

	public TimeSheets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheets(Long timeSheetId, Employees employees, LocalDate date, double hoursWorked,
			TimeSheetsStatus status) {
		super();
		this.timeSheetId = timeSheetId;
		this.employees = employees;
		this.date = date;
		this.hoursWorked = hoursWorked;
		this.status = status;
	}

	public Long getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
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

	@Override
	public String toString() {
		return "TimeSheets [timeSheetId=" + timeSheetId + ", date=" + date
				+ ", hoursWorked=" + hoursWorked + ", status=" + status + "]";
	}

}

