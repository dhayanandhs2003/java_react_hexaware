package com.payroll.backend.repository;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

//    // For looking up/editing by email
//    Employees findByEmail(String email);
//
//    // Filter employees by department
//    List<Employees> findByDepartment(String department);
//
//    // Find employees under a specific manager
//    List<Employees> findByManager(Employees manager);
//
//    // Filter by active/inactive status
//    List<Employees> findByStatus(EmployeeStatus status);
}

