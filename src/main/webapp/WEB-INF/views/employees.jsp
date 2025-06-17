<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Employee Management</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">EasyPay</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="users">Manage Users</a></li>
        <li class="nav-item"><a class="nav-link active" href="employees">Manage Employees</a></li>
        <li class="nav-item"><a class="nav-link" href="payroll">Payroll Dashboard</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
  <div class="row">
    <div class="col-sm-5">
      <h3>${updateEmployee != null ? "Update Employee" : "Add Employee"}</h3>
      <form action="saveEmployee" method="post">
        
        <!-- Hidden field to support update -->
        <c:if test="${updateEmployee != null}">
          <input type="hidden" name="employeeId" value="${updateEmployee.employeeId}" />
        </c:if>

        <div class="mb-3">
          <input type="text" value="${updateEmployee.firstName}" class="form-control" name="firstName" placeholder="First Name" required>
        </div>
        <div class="mb-3">
          <input type="text" value="${updateEmployee.lastName}" class="form-control" name="lastName" placeholder="Last Name">
        </div>
        <div class="mb-3">
          <input type="email" value="${updateEmployee.email}" class="form-control" name="email" placeholder="Email" required>
        </div>
        <div class="mb-3">
          <input type="text" value="${updateEmployee.phone}" class="form-control" name="phone" placeholder="Phone">
        </div>
        <div class="mb-3">
          <input type="date" value="${updateEmployee.hireDate}" class="form-control" name="hireDate" placeholder="Hire Date">
        </div>
        <div class="mb-3">
          <input type="text" value="${updateEmployee.department}" class="form-control" name="department" placeholder="Department">
        </div>
        <div class="mb-3">
          <button type="submit" class="btn btn-success">Save</button>
          <button type="reset" class="btn btn-secondary">Reset</button>
        </div>
      </form>
    </div>

    <div class="col-sm-7 table-responsive">
      <h3>Employee List</h3>
      <table class="table table-bordered">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Hire Date</th>
            <th>Department</th>
            <th colspan="2">Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="emp" items="${employees}">
            <tr>
              <td>${emp.employeeId}</td>
              <td>${emp.firstName}</td>
              <td>${emp.lastName}</td>
              <td>${emp.email}</td>
              <td>${emp.phone}</td>
              <td>${emp.hireDate}</td>
              <td>${emp.department}</td>
              <td><a href="editEmployee/${emp.employeeId}" class="btn btn-sm btn-warning">Edit</a></td>
              <td><a href="deleteEmployee/${emp.employeeId}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?');">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>
