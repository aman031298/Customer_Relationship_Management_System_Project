<%@ page import="com.project.client_magnet.dao.LeadDao" %>
<%@ page import="com.project.client_magnet.model.Lead" %>
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
    <title>Leads</title>
</head>
 <style>
        body {
            background-image: url('scheduleEntry.jpg');
            background-color: #000;
            color: #fff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex; /* Use flexbox for layout */
        }

        /* Left panel styles */
        .left-panel {
            width: 15%;
            background-color: silver;
            height: 100vh;
            overflow: auto;
            transition: width 0.5s;
            position: relative;
        }

        .left-panel ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .left-panel li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .left-panel li a:hover {
            background-color: #c0c0c0;
            color: white;
        }

        /* Toggle button styles */
        .toggle-button {
            position: absolute;
            top: 20px;
            left: 20px;
            background-color: #333;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: left 0.5s;
        }

        .toggle-button:hover {
            background-color: #555;
        }

        /* Main content styles */
        .content {
            flex: 1; /* Take remaining space */
            padding: 20px;
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
            background-color: #333;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

    </style>
<body>
    
     <% 
        // Retrieve error message attribute
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
    <!-- Display error message in JavaScript alert -->
    <script>
        alert("<%= errorMessage %>");
    </script>
    <% } %>
    <!-- Left panel -->
   
    <!-- Main content -->
    <div class="content">
        <h1>Current Leads</h1>
    	<table>
        <tr>
            <th>  </th>
            <th>LeadID</th>
            <th>CompanyID</th>
            <th>ProductID</th>
            <th>Industry</th>
            <th>Source</th>
            <th>InterestLevel</th>
            <th>DealSize</th>
            <th>RepresentativeID</th>
            <th>Action</th> <!-- New column for delete button -->
        </tr>
        <% 
        LeadDao ldao = new LeadDao();
        List<Lead> leads = ldao.findAll();
        int rowNum = 1;
        if(leads==null){
    		request.getRequestDispatcher("empty_leads_show_employee.jsp").forward(request, response);
    	}
        else{
        for (Lead lead : leads) {
        %>
        <tr>
            <td><%= rowNum++ %></td> 
            <td><%= lead.getLeadID() %></td>
            <td><%= lead.getCompany().getCid() %></td>
            <td><%= lead.getProduct().getProductID() %></td>
            <td><%= lead.getIndustryType() %></td>
            <td><%= lead.getSource() %></td>
            <td><%= lead.getInterestLevel() %></td>
            <td><%= lead.getDealSize() %></td>
            <td><%= lead.getRepresentative().getRepID() %></td>
            <td>
                <form action="deleteLeadServlet" method="post"> <!-- Assuming you have a servlet to handle delete operation -->
                    <input type="hidden" name="leadId" value="<%= lead.getLeadID() %>"> <!-- Pass lead ID as hidden input -->
                    <!-- Pass other column values as hidden inputs -->
                    <input type="hidden" name="companyId" value="<%= lead.getCompany().getCid() %>">
                    <input type="hidden" name="productId" value="<%= lead.getProduct().getProductID() %>">
                    <input type="hidden" name="industry" value="<%= lead.getIndustryType() %>">
                    <input type="hidden" name="source" value="<%= lead.getSource() %>">
                    <input type="hidden" name="interestLevel" value="<%= lead.getInterestLevel() %>">
                    <input type="hidden" name="dealSize" value="<%= lead.getDealSize() %>">
                    <input type="hidden" name="representativeId" value="<%= lead.getRepresentative().getRepID() %>">
                    <input type="submit" value="Delete"> <!-- Delete button -->
                </form>
            </td>
        </tr>
        <% } }%>
    </table>
    </div>
</body>
</html>