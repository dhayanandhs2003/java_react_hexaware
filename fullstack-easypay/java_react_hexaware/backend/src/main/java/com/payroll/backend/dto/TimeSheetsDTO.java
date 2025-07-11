package com.payroll.backend.dto;

import java.time.LocalDate;
import com.payroll.backend.enums.TimeSheetsStatus;

public class TimeSheetsDTO {
    private Long timeSheetId;
    private Long employeeId;
    private LocalDate date;
    private double hoursWorked;
    private TimeSheetsStatus status;

    // Constructors
    public TimeSheetsDTO() {}

    public TimeSheetsDTO(Long timeSheetId, Long employeeId, LocalDate date, double hoursWorked, TimeSheetsStatus status) {
        this.timeSheetId = timeSheetId;
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
        this.status = status;
    }

    // Getters and Setters
    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
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

