<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>EasyPay - Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center mb-4">Create an Account</h2>
    <form action="signup" method="post" class="col-md-6 offset-md-3 bg-white p-4 shadow rounded">
        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" name="name" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" name="username" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" name="email" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label for="role" class="form-label">Role</label>
            <select name="role" class="form-select" required>
                <option value="">Select Role</option>
                <option value="admin">Admin / HR Manager</option>
                <option value="employee">Employee</option>
                <option value="processor">Payroll Processor</option>
                <option value="manager">Manager / Supervisor</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary w-100">Sign Up</button>
        <p class="mt-3 text-center">Already have an account? <a href="login">Sign In</a></p>
    </form>
</div>
</body>
</html>
