package com.payroll.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payrolls")
public class Payroll {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employees;

    private String month;
    private int year;

    private BigDecimal baseSalary;
    private BigDecimal benefits;
    private BigDecimal tax;
    private BigDecimal netPay;

    private LocalDate generatedOn;
    
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private PayrollPolicy payrollPolicy;

    @OneToOne
    @JoinColumn(name = "timesheet_id")
    private TimeSheets timeSheet;

	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payroll(Long payrollId, Employees employees, String month, int year, BigDecimal baseSalary,
			BigDecimal benefits, BigDecimal tax, BigDecimal netPay, LocalDate generatedOn, PayrollPolicy payrollPolicy,
			TimeSheets timeSheet) {
		super();
		this.payrollId = payrollId;
		this.employees = employees;
		this.month = month;
		this.year = year;
		this.baseSalary = baseSalary;
		this.benefits = benefits;
		this.tax = tax;
		this.netPay = netPay;
		this.generatedOn = generatedOn;
		this.payrollPolicy = payrollPolicy;
		this.timeSheet = timeSheet;
	}

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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

	public PayrollPolicy getPayrollPolicy() {
		return payrollPolicy;
	}

	public void setPayrollPolicy(PayrollPolicy payrollPolicy) {
		this.payrollPolicy = payrollPolicy;
	}

	public TimeSheets getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheets timeSheet) {
		this.timeSheet = timeSheet;
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", month=" + month + ", year=" + year
				+ ", baseSalary=" + baseSalary + ", benefits=" + benefits + ", tax=" + tax + ", netPay=" + netPay
				+ ", generatedOn=" + generatedOn + "]";
	}
    
}
