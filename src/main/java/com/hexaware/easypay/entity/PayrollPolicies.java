package com.hexaware.easypay.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payroll_policies")
public class PayrollPolicies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Integer policyId;

    @Column(name = "policy_name", nullable = false)
    private String policyName;

    @Column(name = "description")
    private String description;

    @Column(name = "tax_percentage", precision = 5, scale = 2)
    private BigDecimal taxPercentage;

    @Column(name = "benefit_percentage", precision = 5, scale = 2)
    private BigDecimal benefitPercentage;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    // Default constructor
    public PayrollPolicies() {
    }

    // All-args constructor
    public PayrollPolicies(Integer policyId, String policyName, String description,
                           BigDecimal taxPercentage, BigDecimal benefitPercentage, Timestamp createdAt) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.description = description;
        this.taxPercentage = taxPercentage;
        this.benefitPercentage = benefitPercentage;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal getBenefitPercentage() {
        return benefitPercentage;
    }

    public void setBenefitPercentage(BigDecimal benefitPercentage) {
        this.benefitPercentage = benefitPercentage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PayrollPolicies{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", description='" + description + '\'' +
                ", taxPercentage=" + taxPercentage +
                ", benefitPercentage=" + benefitPercentage +
                ", createdAt=" + createdAt +
                '}';
    }
}

