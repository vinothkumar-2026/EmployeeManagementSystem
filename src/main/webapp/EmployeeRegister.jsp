<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
</head>
<body>
<h2>Employee Registration</h2>
<form action="EmployeeRegister" method="post">
Employee ID:
<input type="number" name="employeeid" required>
<br><br>
Name:
<input type="text" name="name" required>
<br><br>
Age:
<input type="number" name="age" required>
<br><br>
Department:
<input type="text" name="department" required>
<br><br>
Salary:
<input type="number" name="salary" required>
<br><br>
Email:
<input type="email" name="email" required>
<br><br>
<input type="submit" value="Register">
</form>
</body>
</html>