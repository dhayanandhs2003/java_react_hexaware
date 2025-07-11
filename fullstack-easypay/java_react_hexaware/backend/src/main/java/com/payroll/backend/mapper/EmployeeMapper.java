package com.payroll.backend.mapper;

import com.payroll.backend.dto.EmployeeDTO;
import com.payroll.backend.dto.request.EmployeesRequestDTO;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Users;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employees employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setDepartment(employee.getDepartment());
        dto.setHireDate(employee.getHireDate());
        dto.setDob(employee.getDob());
        dto.setDesignation(employee.getDesignation());
        dto.setStatus(employee.getStatus());

        if (employee.getManager() != null) {
            dto.setManagerId(employee.getManager().getEmployeeId());
        }

        if (employee.getUser() != null) {
            dto.setUserId(employee.getUser().getUserId());
        }

        return dto;
    }

    public static Employees toEntity(EmployeesRequestDTO dto, Users user, Employees manager) {
        Employees employee = new Employees();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(dto.getDepartment());
        employee.setHireDate(dto.getHireDate());
        employee.setDob(dto.getDob());
        employee.setDesignation(dto.getDesignation());
        employee.setStatus(dto.getStatus());
        employee.setUser(user);
        employee.setManager(manager);
        return employee;
    }
}


