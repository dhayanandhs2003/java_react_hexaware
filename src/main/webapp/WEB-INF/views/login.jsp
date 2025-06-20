<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>EasyPay - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center mb-4">Sign In to EasyPay</h2>
    <form action="${pageContext.request.contextPath}/login" method="post" class="col-md-6 offset-md-3 bg-white p-4 shadow rounded">
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" name="email" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" required/>
        </div>
        <button type="submit" class="btn btn-success w-100">Sign In</button>
        <p class="mt-3 text-center">Don't have an account? <a href="signup">Sign Up</a></p>
    </form>
</div>
</body>
</html>
