package com.payroll.backend.repository;

import com.payroll.backend.entity.Benefits;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.enums.BenefitType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefits, Long> {

//    // Get all benefits of an employee
//    List<Benefits> findByEmployee(Employees employee);
//
//    // Optional: Filter by type
//    List<Benefits> findByType(BenefitType type);
}

