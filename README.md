# 💼 EasyPay – Payroll Management System

**EasyPay** is a full-stack web application designed to manage payroll operations efficiently within an organization. The system supports employee and admin roles, payroll data entry, timesheet tracking, login authentication, and RESTful API integration. Built with Spring Boot (backend) and React (frontend), it ensures modularity, scalability, and role-based access.

---

## 📌 Features

### ✅ User Authentication
- **Login/Signup** via JWT token
- Role-based access control (Admin and Employee)
- Admin can access all modules
- Employee restricted to dashboard, profile, timesheet

### 👨‍💼 Employee Management
- Add, update, and delete employees
- Automatically adds a corresponding user upon employee registration

### 📆 Timesheet Management
- Employees can submit timesheets
- Admin can view all timesheets and update their status (Pending → Approved/Rejected)
- Filters for timesheet view: by Employee ID, Timesheet ID, Status

### 💰 Payroll Management
- Payroll view by employee
- Payroll data displayed dynamically from API

---

## 🛠️ Tech Stack

| Layer       | Technology                     |
|------------|----------------------------------|
| Frontend   | React, Bootstrap 5, Axios       |
| Backend    | Spring Boot, Spring Web MVC, JPA, Hibernate |
| Security   | JWT Token-based authentication  |
| Database   | MySQL                           |
| Tools      | Postman, IntelliJ, VS Code      |

---

## 🧩 Project Structure

EasyPay/
├── backend/
│ ├── com.hexaware.easypay.entity/
│ │ ├── User.java
│ │ ├── Employee.java
│ │ └── TimeSheet.java
│ ├── com.hexaware.easypay.repository/
│ │ ├── UserRepository.java
│ │ ├── EmployeeRepository.java
│ │ └── TimeSheetRepository.java
│ ├── com.hexaware.easypay.controller/
│ │ ├── AuthController.java
│ │ ├── EmployeeController.java
│ │ └── TimeSheetController.java
│ ├── com.hexaware.easypay.config/
│ │ └── SecurityConfig.java
│ └── Application.java
├── frontend/
│ ├── src/
│ │ ├── pages/
│ │ │ ├── LoginPage.jsx
│ │ │ ├── RegisterPage.jsx
│ │ │ ├── Dashboard.jsx
│ │ │ ├── ManageEmployees.jsx
│ │ │ ├── ManageTimesheets.jsx
│ │ │ └── ViewPayroll.jsx
│ │ ├── services/
│ │ │ ├── authService.js
│ │ │ ├── employeeService.js
│ │ │ ├── timeSheetService.js
│ │ │ └── payrollService.js
│ │ └── components/
│ │ ├── Navbar.jsx
│ │ └── ProtectedRoute.jsx
│ └── App.jsx

yaml
Copy
Edit

---

## 🔐 Security & Access Control

- JWT token is stored in `localStorage`
- Role is validated in the frontend to show/hide navigation links
- Backend validates user role for secure endpoints

---

## 🧪 Testing

- Unit tests on backend using JUnit
- API testing using Postman
- UI testing manually with sample employee & timesheet records

---

## 📊 Database Design

### Tables
- **Users**
  - user_id, username, password, role
- **Employees**
  - employee_id, first_name, last_name, email, etc.
- **Timesheets**
  - timesheet_id, employee_id (FK), date, hours_worked, status
- **Payrolls**
  - payroll_id, employee_id, salary, bonuses, deductions

> When an employee is registered, a corresponding user entry is created with role 'employee'.

---

## 🖼️ UI Screens

- 🎯 **Login/Register**
- 🧑‍💼 **Admin Dashboard**
- 📋 **Manage Employees**
- 📅 **Manage Timesheets**
- 💵 **View Payroll**
- 👨‍🔧 **Employee Dashboard** (timesheet submission, payroll view)

---

## 🔧 Setup Instructions

### Backend
```bash
cd backend
mvn spring-boot:run
