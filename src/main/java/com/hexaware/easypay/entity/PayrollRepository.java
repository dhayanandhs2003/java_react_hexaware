package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.Payroll;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
	List<Payroll> findByEmployeeId(Integer employeeId);
}

