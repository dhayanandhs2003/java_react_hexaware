package com.payroll.backend.dto;

import java.time.LocalDate;
import com.payroll.backend.enums.BenefitType;

public class BenefitsDTO {

    private Long benefitId;
    private Long employeeId;
    private String type;
    private BenefitType benefit;
    private LocalDate effectiveDate;

    // Constructors
    public BenefitsDTO() {}

    public BenefitsDTO(Long benefitId, Long employeeId, String type, BenefitType benefit, LocalDate effectiveDate) {
        this.benefitId = benefitId;
        this.employeeId = employeeId;
        this.type = type;
        this.benefit = benefit;
        this.effectiveDate = effectiveDate;
    }

    // Getters and Setters
    public Long getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(Long benefitId) {
        this.benefitId = benefitId;
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

    public void setBenefit(BenefitType benefit) {
        this.benefit = benefit;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}

