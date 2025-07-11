package com.payroll.backend.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollRequestDTO {
    private Long employeeId;
    private String month;
    private int year;
    private BigDecimal baseSalary;
    private BigDecimal benefits;
    private BigDecimal tax;
    private BigDecimal netPay;
    private LocalDate generatedOn;
    private Long policyId;
    private Long timeSheetId;
	public PayrollRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayrollRequestDTO(Long employeeId, String month, int year, BigDecimal baseSalary, BigDecimal benefits,
			BigDecimal tax, BigDecimal netPay, LocalDate generatedOn, Long policyId, Long timeSheetId) {
		super();
		this.employeeId = employeeId;
		this.month = month;
		this.year = year;
		this.baseSalary = baseSalary;
		this.benefits = benefits;
		this.tax = tax;
		this.netPay = netPay;
		this.generatedOn = generatedOn;
		this.policyId = policyId;
		this.timeSheetId = timeSheetId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public Long getTimeSheetId() {
		return timeSheetId;
	}
	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}
    
}
