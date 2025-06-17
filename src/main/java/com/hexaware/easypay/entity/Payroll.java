package com.hexaware.easypay.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payroll_id")
    private Integer payrollId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    @Column(name = "benefits")
    private BigDecimal benefits;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "net_pay")
    private BigDecimal netPay;

    @Column(name = "generated_on")
    private LocalDate generatedOn;

    public Payroll() {
    }

    public Payroll(Integer payrollId, Integer employeeId, String month, Integer year, BigDecimal baseSalary, BigDecimal benefits, BigDecimal tax, BigDecimal netPay, LocalDate generatedOn) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.baseSalary = baseSalary;
        this.benefits = benefits;
        this.tax = tax;
        this.netPay = netPay;
        this.generatedOn = generatedOn;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getBenefits() {
        return benefits;
    }

    public void setBenefits(BigDecimal benefits) {
        this.benefits = benefits;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    public LocalDate getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDate generatedOn) {
        this.generatedOn = generatedOn;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", baseSalary=" + baseSalary +
                ", benefits=" + benefits +
                ", tax=" + tax +
                ", netPay=" + netPay +
                ", generatedOn=" + generatedOn +
                '}';
    }
}

