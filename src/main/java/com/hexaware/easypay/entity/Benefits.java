package com.hexaware.easypay.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "benefits")
public class Benefits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "benefit_id")
    private Integer benefitId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

    @Column(name = "benefit_type", nullable = false)
    private String benefitType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "effective_from")
    private LocalDate effectiveFrom;

    // Constructors
    public Benefits() {
    }

    public Benefits(Integer benefitId, Employees employee, String benefitType, BigDecimal amount, LocalDate effectiveFrom) {
        this.benefitId = benefitId;
        this.employee = employee;
        this.benefitType = benefitType;
        this.amount = amount;
        this.effectiveFrom = effectiveFrom;
    }

    // Getters and Setters
    public Integer getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(Integer benefitId) {
        this.benefitId = benefitId;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    @Override
    public String toString() {
        return "Benefits{" +
                "benefitId=" + benefitId +
                ", employee=" + (employee != null ? employee.getEmployeeId() : null) +
                ", benefitType='" + benefitType + '\'' +
                ", amount=" + amount +
                ", effectiveFrom=" + effectiveFrom +
                '}';
    }
}

