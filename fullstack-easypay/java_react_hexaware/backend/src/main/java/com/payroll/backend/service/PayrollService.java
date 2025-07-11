package com.payroll.backend.service;

import com.payroll.backend.dto.PayrollDTO;
import com.payroll.backend.dto.request.PayrollRequestDTO;

import java.util.List;

public interface PayrollService {
    List<PayrollDTO> getAllPayrolls();
    PayrollDTO getPayrollById(Long payrollId);
    PayrollDTO createPayroll(PayrollRequestDTO requestDTO);
    PayrollDTO updatePayroll(Long payrollId, PayrollRequestDTO requestDTO);
    void deletePayroll(Long payrollId);
}

