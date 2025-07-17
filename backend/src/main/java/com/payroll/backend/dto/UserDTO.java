package com.payroll.backend.dto;

import com.payroll.backend.enums.UserRole;
import java.util.Date;

public class UserDTO {
    private Long userId;
    private String userName;
    private String email;
    private UserRole role;
    private Date createdAt;

    // Default constructor
    public UserDTO() {
    }

    // Parameterized constructor
    public UserDTO(Long userId, String userName, String email, UserRole role, Date createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }
    
 // Required constructor
    public UserDTO(Long id, String name, String email) {
        this.userId = id;
        this.userName = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

