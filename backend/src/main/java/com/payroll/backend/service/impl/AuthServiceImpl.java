package com.payroll.backend.service.impl;

import com.payroll.backend.dto.auth.AuthenticationRequest;
import com.payroll.backend.dto.auth.AuthenticationResponse;
import com.payroll.backend.dto.auth.RegisterRequest;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.EmployeeStatus;
import com.payroll.backend.enums.UserRole;
import com.payroll.backend.repository.EmployeesRepository;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.security.JwtService;
import com.payroll.backend.service.AuthService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // ✅ Register
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Users user = new Users();
        user.setUserName(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail()); // ✅ This must be set!
        user.setRole(request.getRole());

        usersRepository.save(user);

        if (request.getRole() == UserRole.EMPLOYEE) {
            Employees employee = new Employees();
            employee.setUser(user); // link with the saved User
            employee.setFirstName("Default"); // set defaults or fetch from request
            employee.setLastName("Name");
            employee.setEmail(user.getEmail());
            employee.setHireDate(LocalDate.now());
            employee.setStatus(EmployeeStatus.ACTIVE); // or enum
            employeesRepository.save(employee);
        }
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name());
        
        String jwtToken = jwtService.generateToken(claims, user.getUserName());
        return new AuthenticationResponse(jwtToken);
    }

    // ✅ Authenticate
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        Users user = usersRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name());

        String jwtToken = jwtService.generateToken(claims, user.getUserName());
        return new AuthenticationResponse(jwtToken);
    }
}

