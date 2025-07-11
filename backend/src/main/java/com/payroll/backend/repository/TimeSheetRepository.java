package com.payroll.backend.repository;

import com.payroll.backend.entity.TimeSheets;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.enums.TimeSheetsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheets, Long> {

//    // Get all timesheets for an employee
//    List<TimeSheets> findByEmployee(Employees employee);
//
//    // Filter by month and year
//    List<TimeSheets> findByMonthAndYear(String month, int year);
//
//    // Filter by status
//    List<TimeSheets> findByStatus(TimeSheetsStatus status);
}

