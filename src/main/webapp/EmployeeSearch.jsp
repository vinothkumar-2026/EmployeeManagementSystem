<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Employeemodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Employees</title>
</head>
<body>
<h2>Search Employees by Department</h2>
<form action="EmployeeSearch" method="get">
Department:
<input type="text" name="department" required>
<input type="submit" value="Search">
</form>
<br>
<%
ArrayList<Employeemodel> employeeList=(ArrayList<Employeemodel>)request.getAttribute("employeeList");
String department=(String)request.getAttribute("department");
if(employeeList!=null){
%>
<h3>Results for: <%= department %></h3>
<table border="1" cellpadding="8">
<tr>
<th>Employee ID</th>
<th>Name</th>
<th>Age</th>
<th>Department</th>
<th>Salary</th>
<th>Email</th>
</tr>
<%
for(Employeemodel employee:employeeList){
%>
<tr>
<td><%= employee.getEmployeeid() %></td>
<td><%= employee.getName() %></td>
<td><%= employee.getAge() %></td>
<td><%= employee.getDepartment() %></td>
<td><%= employee.getSalary() %></td>
<td><%= employee.getEmail() %></td>
</tr>
<%
}
%>
</table>
<%
if(employeeList.isEmpty()){
%>
<p>No employees found in this department.</p>
<%
}
}
%>
<br>
<a href="Employeedisplay">View All Employees</a>
</body>
</html>