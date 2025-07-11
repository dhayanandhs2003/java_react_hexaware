package com.payroll.backend.repository;

import com.payroll.backend.entity.Payroll;
import com.payroll.backend.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

//    // Get all payroll records for a specific employee
//    List<Payroll> findByEmployees(Employees employee);
//
//    // Filter by month and year
//    List<Payroll> findByMonthAndYear(String month, int year);
}

