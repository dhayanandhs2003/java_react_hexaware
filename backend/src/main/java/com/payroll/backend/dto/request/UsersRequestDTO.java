package com.payroll.backend.dto.request;

import com.payroll.backend.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsersRequestDTO {
    private String userName;  // Match with `dto.getUserName()`
    private String password;
    private String email;
    private UserRole role;

    // Getters & Setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    
 // Required constructor
    public UsersRequestDTO(String name, String email) {
        this.userName = name;
        this.email = email;
    }
    
 // ✅ Default constructor for @RequestBody or manual setting
    public UsersRequestDTO() {}
    public UsersRequestDTO(String userName, String email, String password, UserRole role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }


}

