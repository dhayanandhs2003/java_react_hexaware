package com.payroll.backend.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollPolicyRequestDTO {
    private String policyName;
    private BigDecimal taxRate;
    private BigDecimal bonusPercentage;
    private BigDecimal benefitPercentage;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
	public PayrollPolicyRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayrollPolicyRequestDTO(String policyName, BigDecimal taxRate, BigDecimal bonusPercentage,
			BigDecimal benefitPercentage, LocalDate effectiveFrom, LocalDate effectiveTo) {
		super();
		this.policyName = policyName;
		this.taxRate = taxRate;
		this.bonusPercentage = bonusPercentage;
		this.benefitPercentage = benefitPercentage;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public BigDecimal getBonusPercentage() {
		return bonusPercentage;
	}
	public void setBonusPercentage(BigDecimal bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}
	public BigDecimal getBenefitPercentage() {
		return benefitPercentage;
	}
	public void setBenefitPercentage(BigDecimal benefitPercentage) {
		this.benefitPercentage = benefitPercentage;
	}
	public LocalDate getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(LocalDate effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public LocalDate getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(LocalDate effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

    
}
