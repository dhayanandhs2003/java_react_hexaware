<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>User Management</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">EasyPay</a>
    <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="users">Manage Users</a></li>
                <li class="nav-item"><a class="nav-link" href="employees">Manage Employees</a></li>
                <li class="nav-item"><a class="nav-link" href="payroll">Payroll Dashboard</a></li>
            </ul>
        </div>
  </div>
</nav>

<div class="container mt-4">
  <div class="row">
    <div class="col-sm-5">
      <h3>Add / Update User</h3>
      <form action="register" method="post">
        <div class="mb-3">
          <input type="text" value="${updateUser.username}" class="form-control" name="username" placeholder="Username" required>
        </div>
        <div class="mb-3">
          <input type="email" value="${updateUser.email}" class="form-control" name="email" placeholder="Email" required>
        </div>
        <div class="mb-3">
          <input type="password" value="${updateUser.password}" class="form-control" name="password" placeholder="Password" required>
        </div>
        <div class="mb-3">
          <input type="text" value="${updateUser.role}" class="form-control" name="role" placeholder="Role" required>
        </div>
        <div class="mb-3">
          <button type="submit" class="btn btn-primary">Save</button>
          <button type="reset" class="btn btn-danger">Reset</button>
        </div>
      </form>
    </div>

    <div class="col-sm-7 table-responsive">
      <h3>Users List</h3>
      <table class="table table-bordered">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
            <th colspan="2">Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.userId}</td>
              <td>${user.username}</td>
              <td>${user.email}</td>
              <td>${user.role}</td>
              <td><a href="getUser?email=${user.email}" class="btn btn-sm btn-warning">Edit</a></td>
              <td><a href="delete?email=${user.email}" class="btn btn-sm btn-danger">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>
