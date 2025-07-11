package com.payroll.backend.service.impl;

import com.payroll.backend.dto.PayrollDTO;
import com.payroll.backend.dto.request.PayrollRequestDTO;
import com.payroll.backend.entity.*;
import com.payroll.backend.exception.ResourceNotFoundException;
import com.payroll.backend.repository.*;
import com.payroll.backend.service.PayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private PayrollPolicyRepository payrollPolicyRepository;

    @Autowired
    private TimeSheetRepository timeSheetsRepository;

    @Override
    public List<PayrollDTO> getAllPayrolls() {
        return payrollRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PayrollDTO getPayrollById(Long payrollId) {
        Payroll payroll = payrollRepository.findById(payrollId)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll", "ID", payrollId));
        return mapToDTO(payroll);
    }

    @Override
    public PayrollDTO createPayroll(PayrollRequestDTO dto) {
        Payroll payroll = new Payroll();

        Employees employee = employeesRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", dto.getEmployeeId()));

        PayrollPolicy policy = payrollPolicyRepository.findById(dto.getPolicyId())
                .orElse(null);

        TimeSheets timeSheet = timeSheetsRepository.findById(dto.getTimeSheetId())
                .orElse(null);

        payroll.setEmployees(employee);
        payroll.setMonth(dto.getMonth());
        payroll.setYear(dto.getYear());
        payroll.setBaseSalary(dto.getBaseSalary());
        payroll.setBenefits(dto.getBenefits());
        payroll.setTax(dto.getTax());
        payroll.setNetPay(dto.getNetPay());
        payroll.setGeneratedOn(dto.getGeneratedOn());
        payroll.setPayrollPolicy(policy);
        payroll.setTimeSheet(timeSheet);

        Payroll saved = payrollRepository.save(payroll);
        return mapToDTO(saved);
    }

    @Override
    public PayrollDTO updatePayroll(Long id, PayrollRequestDTO dto) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll", "ID", id));

        Employees employee = employeesRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", dto.getEmployeeId()));

        PayrollPolicy policy = payrollPolicyRepository.findById(dto.getPolicyId()).orElse(null);
        TimeSheets timeSheet = timeSheetsRepository.findById(dto.getTimeSheetId()).orElse(null);

        payroll.setEmployees(employee);
        payroll.setMonth(dto.getMonth());
        payroll.setYear(dto.getYear());
        payroll.setBaseSalary(dto.getBaseSalary());
        payroll.setBenefits(dto.getBenefits());
        payroll.setTax(dto.getTax());
        payroll.setNetPay(dto.getNetPay());
        payroll.setGeneratedOn(dto.getGeneratedOn());
        payroll.setPayrollPolicy(policy);
        payroll.setTimeSheet(timeSheet);

        Payroll updated = payrollRepository.save(payroll);
        return mapToDTO(updated);
    }

    @Override
    public void deletePayroll(Long id) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll", "ID", id));
        payrollRepository.delete(payroll);
    }

    private PayrollDTO mapToDTO(Payroll payroll) {
        return new PayrollDTO(
                payroll.getPayrollId(),
                payroll.getEmployees().getEmployeeId(),
                payroll.getEmployees().getFirstName() + " " + payroll.getEmployees().getLastName(),
                payroll.getMonth(),
                payroll.getYear(),
                payroll.getBaseSalary(),
                payroll.getBenefits(),
                payroll.getTax(),
                payroll.getNetPay(),
                payroll.getGeneratedOn(),
                payroll.getPayrollPolicy() != null ? payroll.getPayrollPolicy().getPolicyId() : null,
                payroll.getPayrollPolicy() != null ? payroll.getPayrollPolicy().getPolicyName() : null,
                payroll.getTimeSheet() != null ? payroll.getTimeSheet().getTimeSheetId() : null
        );
    }
}
