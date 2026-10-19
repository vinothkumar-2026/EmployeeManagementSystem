<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Employeemodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<h2>Update Employee</h2>
<%
Employeemodel employee=(Employeemodel)request.getAttribute("employee");
if(employee!=null){
%>
<form action="EmployeeUpdate" method="post">
Employee ID:
<input type="number" name="employeeid" value="<%= employee.getEmployeeid() %>" readonly>
<br><br>
Name:
<input type="text" value="<%= employee.getName() %>" readonly>
<br><br>
Department:
<input type="text" name="department" value="<%= employee.getDepartment() %>" required>
<br><br>
Salary:
<input type="number" name="salary" value="<%= employee.getSalary() %>" min="0" required>
<br><br>
<input type="submit" value="Update Employee">
</form>
<%
}else{
%>
<p>Employee details not found.</p>
<%
}
%>
<br>
<a href="Employeedisplay">Back to Employee List</a>
</body>
</html>