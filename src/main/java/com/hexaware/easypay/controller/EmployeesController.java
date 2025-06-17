package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Employees;
import com.hexaware.easypay.entity.EmployeesRepository;
import com.hexaware.easypay.entity.Users;
import com.hexaware.easypay.entity.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/employees")
    public String showEmployeesPage(Model model) {
        List<Employees> employeesList = employeesRepository.findAll();
        model.addAttribute("employees", employeesList);
        return "employees";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employees employee, Model model) {
        
        employeesRepository.save(employee);

        
        Users existingUser = usersRepository.findByEmail(employee.getEmail());

        if (existingUser == null) {
            
            Users user = new Users();
            user.setUsername(employee.getFirstName());
            user.setEmail(employee.getEmail());
            user.setPassword("default123"); 
            user.setRole("employee");
            usersRepository.save(user);

            
            employee.setUserId(user.getUserId());
            employeesRepository.save(employee);
        }

        model.addAttribute("employees", employeesRepository.findAll());
        return "employees";
    }

    
    @GetMapping("/editEmployee/{employeeId}")
    public String editEmployee(@PathVariable Integer employeeId, Model model) {
        Employees employee = employeesRepository.findById(employeeId).orElse(null);
        model.addAttribute("updateEmployee", employee);
        model.addAttribute("employees", employeesRepository.findAll());
        return "employees";
    }

    
    @GetMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId, Model model) {
        employeesRepository.deleteById(employeeId);
        model.addAttribute("employees", employeesRepository.findAll());
        return "employees";
    }
}
