package com.payroll.backend.dto.request;

import com.payroll.backend.enums.BenefitType;
import java.time.LocalDate;

public class BenefitsRequestDTO {
    private Long employeeId;
    private String type;
    private BenefitType benefit;
    private LocalDate effectiveDate;
	public BenefitsRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenefitsRequestDTO(Long employeeId, String type, BenefitType benefit, LocalDate effectiveDate) {
		super();
		this.employeeId = employeeId;
		this.type = type;
		this.benefit = benefit;
		this.effectiveDate = effectiveDate;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BenefitType getBenefit() {
		return benefit;
	}
	public void setBenefit(BenefitType benifit) {
		this.benefit = benifit;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

    
}

