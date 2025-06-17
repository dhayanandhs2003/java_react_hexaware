package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}

