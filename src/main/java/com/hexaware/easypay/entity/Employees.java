package com.hexaware.easypay.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "user_id")
    private Integer userId;  

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "designation")
    private String designation;

    @Column(name = "doj")
    private LocalDate doj;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status")
    private String status;  // 'active' or 'inactive'

    @Column(name = "department")
    private String department;

    @Column(name = "first_name", nullable = false)
    private String firstName;

	@Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    
    public Employees(Integer employeeId, Integer userId, String name, String email, LocalDate dob, String designation,
			LocalDate doj, BigDecimal salary, String status, String department, String firstName, LocalDate hireDate,
			String lastName, String phone) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.designation = designation;
		this.doj = doj;
		this.salary = salary;
		this.status = status;
		this.department = department;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.lastName = lastName;
		this.phone = phone;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public LocalDate getHireDate() {
		return hireDate;
	}


	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", userId=" + userId + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + ", designation=" + designation + ", doj=" + doj + ", salary=" + salary + ", status="
				+ status + ", department=" + department + ", firstName=" + firstName + ", hireDate=" + hireDate
				+ ", lastName=" + lastName + ", phone=" + phone + "]";
	}


	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
}
