package com.payroll.backend.controller;

import com.payroll.backend.dto.auth.AuthenticationRequest;
import com.payroll.backend.dto.auth.AuthenticationResponse;
import com.payroll.backend.dto.auth.RegisterRequest;
import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.UserRole;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.security.JwtService;
import com.payroll.backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:3000") // change if needed
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
