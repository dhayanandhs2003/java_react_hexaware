package com.payroll.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollPolicyDTO {
    private Long policyId;
    private String policyName;
    private BigDecimal taxRate;
    private BigDecimal bonusPercentage;
    private BigDecimal benefitPercentage;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    // Constructors
    public PayrollPolicyDTO() {}

    public PayrollPolicyDTO(Long policyId, String policyName, BigDecimal taxRate, BigDecimal bonusPercentage,
                            BigDecimal benefitPercentage, LocalDate effectiveFrom, LocalDate effectiveTo) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.taxRate = taxRate;
        this.bonusPercentage = bonusPercentage;
        this.benefitPercentage = benefitPercentage;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
    }

    // Getters and Setters
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
}
