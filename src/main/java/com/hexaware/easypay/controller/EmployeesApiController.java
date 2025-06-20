package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Employees;
import com.hexaware.easypay.entity.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesApiController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @PostMapping
    public Employees addEmployee(@RequestBody Employees emp) {
        return employeesRepository.save(emp);
    }

    @GetMapping("/{id}")
    public Employees getEmployeeById(@PathVariable Integer id) {
        return employeesRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employees updateEmployee(@PathVariable Integer id, @RequestBody Employees empDetails) {
        Employees emp = employeesRepository.findById(id).orElse(null);
        if (emp != null) {
            emp.setFirstName(empDetails.getFirstName());
            emp.setLastName(empDetails.getLastName());
            emp.setEmail(empDetails.getEmail());
            emp.setPhone(empDetails.getPhone());
            emp.setHireDate(empDetails.getHireDate());
            emp.setDepartment(empDetails.getDepartment());
            return employeesRepository.save(emp);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeesRepository.deleteById(id);
    }
}

