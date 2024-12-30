<%@ page import="com.project.client_magnet.dao.ScheduleDao" %>
<%@ page import="com.project.client_magnet.model.Schedule" %>
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
    <title>Schedule</title>
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
    <h1>Schedule List</h1>
    <table border="1">
        <tr>
        	<th>  </th>
            <th>RepID</th>
            <th>EmpID</th>
            <th>InteractionType</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        <% 
        ScheduleDao sdao = new ScheduleDao();
            List<Schedule> schedules = sdao.findAll();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
            int rowNum = 1; 
            for (Schedule schedule : schedules) {
                java.sql.Timestamp timestamp = schedule.getPreferredTime(); // Assuming this method exists in your Student class to retrieve the timestamp
                String dateStr = dateFormatter.format(timestamp);
                String timeStr = timeFormatter.format(timestamp);
        %>
        <tr>
        	<td><%= rowNum++ %></td> 
            <td><%= schedule.getRepresentative().getRepID() %></td>
            <td><%= schedule.getEmployee().getEmpID() %></td>
            <td><%= schedule.getInteractionType() %></td>
            <td><%= dateStr %></td>
            <td><%= timeStr %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
