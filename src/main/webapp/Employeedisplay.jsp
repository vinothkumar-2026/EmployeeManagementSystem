<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Employeemodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
<h2>Employee Details</h2>
<a href="EmployeeRegister.jsp">Register New Employee</a>
<br><br>
<table border="1" cellpadding="8">
<tr>
<th>Employee ID</th>
<th>Name</th>
<th>Age</th>
<th>Department</th>
<th>Salary</th>
<th>Email</th>
<th>Action</th>
</tr>
<%
ArrayList<Employeemodel> employeeList=(ArrayList<Employeemodel>)request.getAttribute("employeeList");
if(employeeList!=null){
    for(Employeemodel employee:employeeList){
%>
<tr>
<td><%= employee.getEmployeeid() %></td>
<td><%= employee.getName() %></td>
<td><%= employee.getAge() %></td>
<td><%= employee.getDepartment() %></td>
<td><%= employee.getSalary() %></td>
<td><%= employee.getEmail() %></td>
<td>
<a href="EmployeeUpdate?employeeid=<%= employee.getEmployeeid() %>">Update</a>
|
<a href="EmployeeDelete?employeeid=<%= employee.getEmployeeid() %>">Delete</a>
</td>
</tr>
<%
    }
}
%>
</table>
<br>
<a href="EmployeeSearch.jsp">Search by Department</a>
</body>
</html>