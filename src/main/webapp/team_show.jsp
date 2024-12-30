<%@ page import="com.project.client_magnet.dao.TeamDao" %>
<%@ page import="com.project.client_magnet.model.Team" %>
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
    <title>Teams</title>
</head>
<style>
        body {
            background-image: url('scheduleEntry.jpg'); /* Background image */
            background-color: #000; /* Black background color */
            color: #fff; /* White text color */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #fff; /* Blue color for headings */
        }

        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #fff;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff;
        }

        tr {
            background-color: #333;
        }
        
        ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 15%;
    background-color: silver; /* Change the background color to silver */
    height: calc(100vh - 40px);
    overflow: auto;
    float: left;
    transition: width 0.5s; /* Add a transition effect for smoother animation */
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
    font-weight: bold;
    transition: background-color 0.3s; /* Add a transition effect for smoother color change */
}

li a:hover {
    background-color: #c0c0c0; /* Change the background color on hover */
    color: white;
}


        
 li {
        margin: 20px 0;
    }

        .container {
            margin-left: 15%;
            padding: 20px;
            height: calc(100vh - 20px);
            display: flex;
            flex-wrap: wrap;
        }   
 
</style>
<body>
<!-- Left panel -->
    
    <h1>Team List</h1>
    <table border="1">
        <tr>
        	<th>  </th>
            <th>TeamID</th>
            <th>Team</th>
            
        </tr>
        <% 
        TeamDao tdao = new TeamDao();
            List<Team> teams = tdao.findAll();
            int rowNum = 1; 
            for (Team team : teams) {

   
        %>
        <tr>
        	<td><%= rowNum++ %></td> 
            <td><%= team.getTeamId() %></td>
            <td><%= team.getTeamName() %></td>

        </tr>
        <% } %>
    </table>
</body>
</html>
