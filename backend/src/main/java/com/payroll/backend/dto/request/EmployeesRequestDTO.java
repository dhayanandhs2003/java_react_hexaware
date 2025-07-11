package com.payroll.backend.dto.request;

import com.payroll.backend.enums.EmployeeStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class EmployeesRequestDTO {
    private Long userId;

    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String phone;
    private String department;
    private LocalDate hireDate;
    private LocalDate dob;
    private String designation;
    private EmployeeStatus status;
    private Long managerId;
    
    
    
	public EmployeesRequestDTO(Long userId, @NotBlank String firstName, String lastName, @Email String email,
			String phone, String department, LocalDate hireDate, LocalDate dob, String designation,
			EmployeeStatus status, Long managerId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.hireDate = hireDate;
		this.dob = dob;
		this.designation = designation;
		this.status = status;
		this.managerId = managerId;
	}
	public EmployeesRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public EmployeeStatus getStatus() {
		return status;
	}
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

    // Getters and Setters
    
}
