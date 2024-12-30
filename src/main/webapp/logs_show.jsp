<%@ page import="com.project.client_magnet.dao.LogsDao" %>
<%@ page import="com.project.client_magnet.model.Logs" %>
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
    <title>Logs</title>
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
</head>
<body>
    <h1>Log List</h1>
    <table>
        <tr>
        	<th>  </th>
            <th>RepID</th>
            <th>EmpID</th>
            <th>InteractionType</th>
            <th>Date</th>
            <th>Notes</th>
        </tr>
        <% 
        LogsDao sdao = new LogsDao();
            List<Logs> logs = sdao.findAll();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            int rowNum = 1; 
            for (Logs log : logs) {
                java.sql.Date date = log.getDates(); // Assuming this method exists in your Student class to retrieve the timestamp
                String dateStr = dateFormatter.format(date);
   
        %>
        <tr>
        	<td><%= rowNum++ %></td> 
            <td><%= log.getRepresentative().getRepID() %></td>
            <td><%= log.getEmployee().getEmpID() %></td>
            <td><%= log.getInteractionType() %></td>
            <td><%= dateStr %></td>
            <td><%= log.getNotes() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
