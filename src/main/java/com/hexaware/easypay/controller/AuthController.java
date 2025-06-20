package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Users;
import com.hexaware.easypay.entity.UsersRepository;

import jakarta.servlet.http.HttpServletRequest;

import com.hexaware.easypay.entity.Employees;
import com.hexaware.easypay.entity.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    // Show signup page
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    // Handle signup POST
    @PostMapping("/signup")
    public String handleSignup(@RequestParam String name,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role,
                               Model model) {

        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);
        usersRepository.save(newUser);

        if (role.equals("employee")) {
            Employees emp = new Employees();
            emp.setFirstName(name);
            emp.setEmail(email);
            emp.setPhone("N/A");
            emp.setDepartment("N/A");
            emp.setUserId(newUser.getUserId());
            employeesRepository.save(emp);
        }

        return "redirect:/login";
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Handle login POST
    @PostMapping("/login")
    public String handleLogin(@RequestParam String email,
                              @RequestParam String password,
                              HttpServletRequest request,
                              Model model) {
        Users user = usersRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // Store role and userId in session temporarily for access control
            request.getSession().setAttribute("userRole", user.getRole().toLowerCase());
            request.getSession().setAttribute("userId", user.getUserId());
            request.getSession().setAttribute("username", user.getUsername());
            return "redirect:/index";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();  // Clears session
        return "redirect:/login";           // Redirect to login page
    }

}
