<%@ page import="com.project.client_magnet.dao.CustomerDao" %>
<%@ page import="com.project.client_magnet.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("email") == null)
	response.sendRedirect("login.jsp");
String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
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
    <h1>Customer List</h1>
    <table border="1">
        <tr>
        	<th>  </th>
            <th>ID</th>
            <th>Name</th>
            <th>ProductID</th>
            <th>Industry</th>
            <th>Address</th>
            <th>Email</th>
        </tr>
        <% 
        CustomerDao sdao = new CustomerDao();
            List<Customer> customers = sdao.findAll();
            int rowNum = 1; 
            for (Customer customer : customers) {
        %>
        <tr>
        	<td><%= rowNum++ %></td> 
            <td><%= customer.getCustID() %></td>
            <td><%= customer.getCustName() %></td>
            <td><%= customer.getProduct().getProductID() %></td>
            <td><%= customer.getIndustryType() %></td>
            <td><%= customer.getAddress() %></td>
            <td><%= customer.getEmail() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
