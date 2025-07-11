package com.payroll.backend.dto.auth;

import com.payroll.backend.enums.UserRole;

public class RegisterRequest {
    private String username;
    private String password;
    private String email;           // ✅ Added email
    private UserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {       // ✅ Getter
        return email;
    }

    public void setEmail(String email) {  // ✅ Setter
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
