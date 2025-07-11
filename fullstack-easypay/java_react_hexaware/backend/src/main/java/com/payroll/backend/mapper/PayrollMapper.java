package com.payroll.backend.mapper;

import com.payroll.backend.dto.PayrollDTO;
import com.payroll.backend.dto.request.PayrollRequestDTO;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Payroll;
import com.payroll.backend.entity.PayrollPolicy;
import com.payroll.backend.entity.TimeSheets;

public class PayrollMapper {

    public static PayrollDTO mapToPayrollDTO(Payroll payroll) {
        PayrollDTO dto = new PayrollDTO();
        dto.setPayrollId(payroll.getPayrollId());
        dto.setEmployeeId(payroll.getEmployees().getEmployeeId());
        dto.setMonth(payroll.getMonth());
        dto.setYear(payroll.getYear());
        dto.setBaseSalary(payroll.getBaseSalary());
        dto.setBenefits(payroll.getBenefits());
        dto.setTax(payroll.getTax());
        dto.setNetPay(payroll.getNetPay());
        dto.setGeneratedOn(payroll.getGeneratedOn());
        dto.setPolicyId(payroll.getPayrollPolicy() != null ? payroll.getPayrollPolicy().getPolicyId() : null);
        dto.setTimeSheetId(payroll.getTimeSheet() != null ? payroll.getTimeSheet().getTimeSheetId() : null);
        return dto;
    }

    public static Payroll mapToPayroll(PayrollRequestDTO dto, Employees employee, PayrollPolicy policy, TimeSheets timesheet) {
        Payroll payroll = new Payroll();
        payroll.setEmployees(employee);
        payroll.setMonth(dto.getMonth());
        payroll.setYear(dto.getYear());
        payroll.setBaseSalary(dto.getBaseSalary());
        payroll.setBenefits(dto.getBenefits());
        payroll.setTax(dto.getTax());
        payroll.setNetPay(dto.getNetPay());
        payroll.setGeneratedOn(dto.getGeneratedOn());
        payroll.setPayrollPolicy(policy);
        payroll.setTimeSheet(timesheet);
        return payroll;
    }
}

