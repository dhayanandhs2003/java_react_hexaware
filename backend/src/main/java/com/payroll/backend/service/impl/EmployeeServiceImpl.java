package com.payroll.backend.service.impl;

import com.payroll.backend.dto.EmployeeDTO;
import com.payroll.backend.dto.request.EmployeesRequestDTO;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Users;
import com.payroll.backend.exception.ResourceNotFoundException;
import com.payroll.backend.repository.EmployeesRepository;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepository employeeRepository;

    @Autowired
    private UsersRepository userRepository;

    // Convert entity to DTO
    private EmployeeDTO toDTO(Employees e) {
        return new EmployeeDTO(
                e.getEmployeeId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getPhone(),
                e.getDepartment(),
                e.getHireDate(),
                e.getDob(),
                e.getDesignation(),
                e.getStatus(),
                e.getUser() != null ? e.getUser().getUserId() : null,
                e.getManager() != null ? e.getManager().getEmployeeId() : null
        );
    }

    // Convert request DTO to entity (new)
    private Employees toEntity(EmployeesRequestDTO dto) {
        Employees employee = new Employees();
        Users user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + dto.getUserId()));
        employee.setUser(user);

        if (dto.getManagerId() != null) {
            Employees manager = employeeRepository.findById(dto.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manager not found with ID: " + dto.getManagerId()));
            employee.setManager(manager);
        }

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(dto.getDepartment());
        employee.setHireDate(dto.getHireDate());
        employee.setDob(dto.getDob());
        employee.setDesignation(dto.getDesignation());
        employee.setStatus(dto.getStatus());

        return employee;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employees employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        return toDTO(employee);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeesRequestDTO dto) {
        Employees employee = toEntity(dto);
        Employees saved = employeeRepository.save(employee);
        return toDTO(saved);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeesRequestDTO dto) {
        Employees existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        Users user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + dto.getUserId()));
        existing.setUser(user);

        if (dto.getManagerId() != null) {
            Employees manager = employeeRepository.findById(dto.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manager not found with ID: " + dto.getManagerId()));
            existing.setManager(manager);
        } else {
            existing.setManager(null);
        }

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setDepartment(dto.getDepartment());
        existing.setHireDate(dto.getHireDate());
        existing.setDob(dto.getDob());
        existing.setDesignation(dto.getDesignation());
        existing.setStatus(dto.getStatus());

        // 🔁 Reflect changes in Users table as well
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getFirstName().toLowerCase());
        userRepository.save(user);

        Employees updated = employeeRepository.save(existing);
        return toDTO(updated);
    }


    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
