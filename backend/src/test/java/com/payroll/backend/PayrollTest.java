package com.payroll.backend;

import org.junit.jupiter.api.Test;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Payroll;
import com.payroll.backend.entity.PayrollPolicy;
import com.payroll.backend.entity.TimeSheets;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollTest {

    @Test
    public void testPayroll_SettersAndGetters() {
        Payroll payroll = new Payroll();

        Employees employee = new Employees();
        PayrollPolicy policy = new PayrollPolicy();
        TimeSheets timeSheet = new TimeSheets();
        LocalDate generatedOn = LocalDate.of(2024, 12, 1);

        payroll.setPayrollId(101L);
        payroll.setEmployees(employee);
        payroll.setMonth("December");
        payroll.setYear(2024);
        payroll.setBaseSalary(new BigDecimal("50000.00"));
        payroll.setBenefits(new BigDecimal("5000.00"));
        payroll.setTax(new BigDecimal("8000.00"));
        payroll.setNetPay(new BigDecimal("47000.00"));
        payroll.setGeneratedOn(generatedOn);
        payroll.setPayrollPolicy(policy);
        payroll.setTimeSheet(timeSheet);

        assertEquals(101L, payroll.getPayrollId());
        assertEquals(employee, payroll.getEmployees());
        assertEquals("December", payroll.getMonth());
        assertEquals(2024, payroll.getYear());
        assertEquals(new BigDecimal("50000.00"), payroll.getBaseSalary());
        assertEquals(new BigDecimal("5000.00"), payroll.getBenefits());
        assertEquals(new BigDecimal("8000.00"), payroll.getTax());
        assertEquals(new BigDecimal("47000.00"), payroll.getNetPay());
        assertEquals(generatedOn, payroll.getGeneratedOn());
        assertEquals(policy, payroll.getPayrollPolicy());
        assertEquals(timeSheet, payroll.getTimeSheet());
    }

    @Test
    public void testPayroll_Constructor() {
        Employees employee = new Employees();
        PayrollPolicy policy = new PayrollPolicy();
        TimeSheets timeSheet = new TimeSheets();
        LocalDate generatedOn = LocalDate.of(2025, 1, 15);

        Payroll payroll = new Payroll(
                200L,
                employee,
                "January",
                2025,
                new BigDecimal("60000.00"),
                new BigDecimal("7000.00"),
                new BigDecimal("9000.00"),
                new BigDecimal("58000.00"),
                generatedOn,
                policy,
                timeSheet
        );

        assertEquals(200L, payroll.getPayrollId());
        assertEquals(employee, payroll.getEmployees());
        assertEquals("January", payroll.getMonth());
        assertEquals(2025, payroll.getYear());
        assertEquals(new BigDecimal("60000.00"), payroll.getBaseSalary());
        assertEquals(new BigDecimal("7000.00"), payroll.getBenefits());
        assertEquals(new BigDecimal("9000.00"), payroll.getTax());
        assertEquals(new BigDecimal("58000.00"), payroll.getNetPay());
        assertEquals(generatedOn, payroll.getGeneratedOn());
        assertEquals(policy, payroll.getPayrollPolicy());
        assertEquals(timeSheet, payroll.getTimeSheet());
    }

    @Test
    public void testToStringIncludesKeyFields() {
        Payroll payroll = new Payroll();
        payroll.setPayrollId(300L);
        payroll.setMonth("March");
        payroll.setYear(2025);
        payroll.setBaseSalary(new BigDecimal("55000.00"));
        payroll.setBenefits(new BigDecimal("6000.00"));
        payroll.setTax(new BigDecimal("8500.00"));
        payroll.setNetPay(new BigDecimal("52500.00"));
        payroll.setGeneratedOn(LocalDate.of(2025, 3, 31));

        String toString = payroll.toString();

        assertTrue(toString.contains("March"));
        assertTrue(toString.contains("55000.00"));
        assertTrue(toString.contains("52500.00"));
        assertTrue(toString.contains("2025"));
    }
}
