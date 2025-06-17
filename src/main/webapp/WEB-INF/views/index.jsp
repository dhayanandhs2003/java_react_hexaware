<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EasyPay - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">EasyPay</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="users">Manage Users</a></li>
                <li class="nav-item"><a class="nav-link" href="employees">Manage Employees</a></li>
                <li class="nav-item"><a class="nav-link" href="payroll">Payroll Dashboard</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5 text-center">
    <h1>Welcome to EasyPay Payroll Management</h1>
    <p class="lead">Use the navigation bar above to manage users, employees, and payroll.</p>

    <div class="row justify-content-center mt-4">
        <div class="col-md-8">
            <div class="card shadow-lg border-0">
                <div class="card-body">
                    <h4 class="card-title">What is EasyPay?</h4>
                    <p class="card-text">
                        <strong>EasyPay</strong> is a simplified and robust payroll and employee management platform
                        designed to streamline operations for organizations of all sizes.
                        It enables admins to manage user roles, onboard employees, handle payroll data,
                        and ensure a secure, seamless workflow for HR teams.
                    </p>
                    <ul class="list-group list-group-flush text-start">
                        <li class="list-group-item">👥 Manage user roles and permissions</li>
                        <li class="list-group-item">📋 Add and track employee records</li>
                        <li class="list-group-item">💰 Generate and monitor payroll efficiently</li>
                        <li class="list-group-item">🔒 Ensures security and consistency in user data</li>
                    </ul>
                    <div class="mt-4 text-center">
                        <a href="employees" class="btn btn-primary me-2">Get Started with Employees</a>
                        <a href="users" class="btn btn-secondary">Manage Users</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
