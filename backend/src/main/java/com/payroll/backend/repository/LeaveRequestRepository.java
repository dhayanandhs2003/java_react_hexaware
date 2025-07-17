package com.payroll.backend.repository;

import com.payroll.backend.entity.LeaveRequest;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.enums.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

	// ✅ Add this method to fetch all leave requests by employeeId
	List<LeaveRequest> findByEmployee_EmployeeId(Long employeeId);

	
//    // Get all leave requests by an employee
//    List<LeaveRequest> findByEmployee(Employees employee);
//
//    // Optional: Filter leave requests by status (PENDING, APPROVED, REJECTED)
//    List<LeaveRequest> findByStatus(LeaveStatus status);
}

