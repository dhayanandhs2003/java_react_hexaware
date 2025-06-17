package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
    List<Timesheet> findByEmployeeEmployeeId(Integer employeeId);
}
