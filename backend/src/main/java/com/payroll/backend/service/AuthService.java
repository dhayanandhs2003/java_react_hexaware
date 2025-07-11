package com.payroll.backend.service;

import com.payroll.backend.dto.auth.AuthenticationRequest;
import com.payroll.backend.dto.auth.AuthenticationResponse;
import com.payroll.backend.dto.auth.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
