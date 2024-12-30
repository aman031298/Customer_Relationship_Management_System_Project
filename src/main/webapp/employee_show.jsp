<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.client_magnet.model.Employee"%>
<%@ page import="com.project.client_magnet.model.Team"%>
<%@ page import="com.project.client_magnet.dao.EmployeeDao"%>
<%@ page import="java.util.List"%>
<%
if (session.getAttribute("email") == null)
	response.sendRedirect("login.jsp");
String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body {
     background-image: url('scheduleEntry.jpg');
        background-color: #222;
        color: #fff;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        margin-top: 20px;
        color: #fff;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #fff;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #007bff;
        color: #fff;
    }

    tr {
        background-color: #333;
    }

    tr:hover {
        background-color: #555;
    }
</style>
<body>

	<h1>Employee List</h1>
	<table border="1">
		<tr>
			<th></th>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>TeamID</th>
			<th>Email</th>
			<th>Mobile</th>
		</tr>
		<%
		EmployeeDao edao = new EmployeeDao();
		List<Employee> emp = edao.findAll();
		int rowNum = 1;
		for (Employee employee : emp) {
		%>
		<tr>
			<td><%=rowNum++%></td>
			<td><%=employee.getEmpID()%></td>
			<td><%=employee.getEmpName()%></td>
			<td><%=employee.getTeam().getTeamId()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getMobile()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>