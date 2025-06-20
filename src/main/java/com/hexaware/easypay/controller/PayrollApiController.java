package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Payroll;
import com.hexaware.easypay.entity.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollApiController {

    @Autowired
    private PayrollRepository payrollRepository;

    // Get all payrolls
    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    // Get payroll by ID
    @GetMapping("/{id}")
    public Payroll getPayrollById(@PathVariable Integer id) {
        return payrollRepository.findById(id).orElse(null);
    }

    // Add new payroll
    @PostMapping
    public Payroll addPayroll(@RequestBody Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    // Update existing payroll
    @PutMapping("/{id}")
    public Payroll updatePayroll(@PathVariable Integer id, @RequestBody Payroll updatedPayroll) {
        Payroll existing = payrollRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setEmployeeId(updatedPayroll.getEmployeeId());
            existing.setMonth(updatedPayroll.getMonth());
            existing.setYear(updatedPayroll.getYear());
            existing.setBaseSalary(updatedPayroll.getBaseSalary());
            existing.setBenefits(updatedPayroll.getBenefits());
            existing.setTax(updatedPayroll.getTax());
            existing.setNetPay(updatedPayroll.getNetPay());
            existing.setGeneratedOn(updatedPayroll.getGeneratedOn());
            return payrollRepository.save(existing);
        }
        return null;
    }

    // Delete payroll by ID
    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Integer id) {
        payrollRepository.deleteById(id);
    }
}

