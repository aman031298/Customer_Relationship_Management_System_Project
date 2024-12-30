<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.client_magnet.model.Company"%>
<%@ page import="com.project.client_magnet.dao.CompanyDao"%>
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
	color: #FFF;
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
	<h1>Company List</h1>
	<table border="1">
		<tr>
			<th></th>
			<th>Company ID</th>
			<th>Company Name</th>
			<th>Address</th>
			<th>Email</th>
		</tr>
		<%
		CompanyDao cdao = new CompanyDao();
		List<Company> companies = cdao.findAll();
		int rowNum = 1;
		for (Company company : companies) {
		%>
		<tr>
			<td><%=rowNum++%></td>
			<td><%=company.getCid()%></td>
			<td><%=company.getCname()%></td>
			<td><%=company.getAddress()%></td>
			<td><%=company.getEmail()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>