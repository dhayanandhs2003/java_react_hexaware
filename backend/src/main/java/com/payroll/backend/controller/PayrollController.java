package com.payroll.backend.controller;

import com.payroll.backend.dto.PayrollDTO;
import com.payroll.backend.dto.request.PayrollRequestDTO;
import com.payroll.backend.service.PayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
@CrossOrigin
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping
    public List<PayrollDTO> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> getPayrollById(@PathVariable Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
    }

    @PostMapping
    public ResponseEntity<PayrollDTO> createPayroll(@RequestBody PayrollRequestDTO requestDTO) {
        return ResponseEntity.ok(payrollService.createPayroll(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollDTO> updatePayroll(@PathVariable Long id, @RequestBody PayrollRequestDTO requestDTO) {
        return ResponseEntity.ok(payrollService.updatePayroll(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}
