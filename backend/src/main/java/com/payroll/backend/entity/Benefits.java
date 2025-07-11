package com.payroll.backend.entity;

import java.time.LocalDate;

import com.payroll.backend.enums.BenefitType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "benefits")
public class Benefits {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefitId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee; // Many benefits can belong to one employee

    @Column(nullable = false)
    private String type; // e.g., health, travel, food, etc.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BenefitType benefit;

    @Column(nullable = false)
    private LocalDate effectiveDate;

	public Benefits() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Benefits(Long benefitId, Employees employee, String type, BenefitType benifit, LocalDate effectiveDate) {
		super();
		this.benefitId = benefitId;
		this.employee = employee;
		this.type = type;
		this.benefit = benifit;
		this.effectiveDate = effectiveDate;
	}

	public Long getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
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

	@Override
	public String toString() {
		return "Benefits [benefitId=" + benefitId + ", type=" + type + ", benifit=" + benefit
				+ ", effectiveDate=" + effectiveDate + "]";
	}
    
}
