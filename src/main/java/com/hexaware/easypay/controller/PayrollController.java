package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Payroll;
import com.hexaware.easypay.entity.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollRepository payrollRepository;

    // Get payroll by employee ID
    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getPayrollByEmployeeId(@PathVariable Integer employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }
}



