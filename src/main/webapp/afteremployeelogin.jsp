<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
if (session.getAttribute("email") == null)
	response.sendRedirect("login.jsp");
String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRM </title>
    <link rel="stylesheet" href="afteradminlogin.css">
</head>
<style>
body {
    background-image: url('crm.webp');
    background-size: cover;
    background-position: center;
    height: 100vh;
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

.container {
    display: flex;
    flex-direction: row;
    height: 100vh;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 15%;
    background-color: silver;
    height: 100%;
    overflow: auto;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
    font-weight: bold;
}

li a:hover {
    background-color: #c0c0c0;
    color: white;
}

.myimage {
    flex: 1;
    background-image: url('crm.webp');
    background-size: cover;
    background-position: center;
}

</style>
<body>
    <div class="container">
		<ul>
			<li><a href="leads_show_employee.jsp">Lead</a></li>
			<li><a href="team_show.jsp">Team</a></li>
			<li><a href="product_show.jsp">Product</a></li>
			<li><a href="company_show.jsp">Company</a></li>
			<li><a href="schedule_show_employee.jsp">Schedule</a></li>
			<li><a href="logs_show.jsp">Logs</a></li>
			<li><a href="customer_show.jsp">Customers</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
		<div class="myimage"></div>
	</div>
</body>
</html>