<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Employeemodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
</head>
<body>
<h2>Delete Employee</h2>
<%
Employeemodel employee=(Employeemodel)request.getAttribute("employee");
if(employee!=null){
%>
<p>Are you sure you want to delete this employee?</p>
<p>Employee ID: <%= employee.getEmployeeid() %></p>
<p>Name: <%= employee.getName() %></p>
<form action="EmployeeDelete" method="post">
<input type="hidden" name="employeeid" value="<%= employee.getEmployeeid() %>">
<input type="submit" value="Confirm Delete">
</form>
<%
}else{
%>
<p>Employee details not found.</p>
<%
}
%>
<br>
<a href="Employeedisplay">Cancel and Go Back</a>
</body>
</html>