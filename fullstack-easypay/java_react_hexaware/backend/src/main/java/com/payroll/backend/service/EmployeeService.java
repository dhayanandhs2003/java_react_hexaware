package com.payroll.backend.service;

import com.payroll.backend.dto.EmployeeDTO;
import com.payroll.backend.dto.request.EmployeesRequestDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);
    EmployeeDTO createEmployee(EmployeesRequestDTO requestDTO);
    EmployeeDTO updateEmployee(Long employeeId, EmployeesRequestDTO requestDTO);
    void deleteEmployee(Long employeeId);
}
