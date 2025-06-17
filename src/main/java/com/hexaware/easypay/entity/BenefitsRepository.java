package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.Benefits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitsRepository extends JpaRepository<Benefits, Integer> {
    List<Benefits> findByEmployeeEmployeeId(Integer employeeId); // Get all benefits for an employee
}
