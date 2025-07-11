package com.payroll.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payroll_policies")
public class PayrollPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    private String policyName;

    private BigDecimal taxRate;
    private BigDecimal bonusPercentage;
    private BigDecimal benefitPercentage;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    
	public PayrollPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PayrollPolicy(Long policyId, String policyName, BigDecimal taxRate, BigDecimal bonusPercentage,
			BigDecimal benefitPercentage, LocalDate effectiveFrom, LocalDate effectiveTo) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.taxRate = taxRate;
		this.bonusPercentage = bonusPercentage;
		this.benefitPercentage = benefitPercentage;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
	}
	
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
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
	
	@Override
	public String toString() {
		return "PayrollPolicy [policyId=" + policyId + ", policyName=" + policyName + ", taxRate=" + taxRate
				+ ", bonusPercentage=" + bonusPercentage + ", benefitPercentage=" + benefitPercentage
				+ ", effectiveFrom=" + effectiveFrom + ", effectiveTo=" + effectiveTo + "]";
	}

    
    
}

