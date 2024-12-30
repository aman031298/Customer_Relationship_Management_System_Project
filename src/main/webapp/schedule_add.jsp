<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.project.client_magnet.dao.RepresentativeDao" %>
<%@ page import="com.project.client_magnet.model.Representative" %>
<%@ page import="com.project.client_magnet.dao.EmployeeDao" %>
<%@ page import="com.project.client_magnet.model.Employee" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule Entry Form</title>

<style>
   body {
        background-image: url('scheduleEntry.jpg'); /* Background image */
        background-color: #007bff; /* Blue background color */
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-size: cover; /* Ensure the image covers the entire background */
        background-repeat: no-repeat; /* Prevent the image from repeating */
    }

    h2 {
        text-align: center;
        margin-top: 20px;
    }

    form {
        max-width: 800px; /* Increased max-width to make the form box bigger */
        margin: 20px auto;
        padding: 30px; /* Increased padding */
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    label {
        display: inline-block;
        width: 150px;
        margin-right: 10px;
    }
 h2 {
            text-align: center;
            margin-top: 20px;
            color: white; /* Set color to white */
        }

    select,
    input[type="date"],
    input[type="submit"] {
        width: 240px; /* Increased width */
        padding: 12px; /* Increased padding */
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    select {
        width: 260px; /* Increased width */
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

        .card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin: 10px;
            width: calc(50% - 20px);
            height: calc(50% - 20px);
            background-color: #f9f9f9;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            background-size: contain;
            background-position: center;
            background-repeat: no-repeat;
        }

        .card:hover {
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
        }

        .card h3 {
            margin-top: 0;
        }

        .card-content {
            flex-grow: 1;
            color: black; /* Set the text color to black */
        }

        /* Styles for the welcome message */
        .welcome-message {
            font-size: 24px; /* Adjust the font size as needed */
            font-weight: bold;
            margin-bottom: 10px;
        }

        /* Styles for the toggle button */
        .toggle-button {
            position: absolute;
            top: 20px;
            left: 20px; /* Adjust left position for the button */
            background-color: #333;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        .toggle-button:hover {
            background-color: #555;
        }

        /* Styles for the container when the left panel is closed */
        .container-closed {
            margin-left: 0;
        }

        /* Styles for the ul when the left panel is closed */
        .ul-closed {
            width: 0;
            overflow: hidden;
        }
    
</style>
</head>
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
<%
    }
%>
	<h2>Schedule Entry Form</h2>
    <div class="top-header">
        <button class="toggle-button" onclick="togglePanel()">&#9776;</button>

    </div>

    <ul id="left-panel" class="ul-closed">
        <li><a href="schedule_add.jsp">Add Schedule</a></li>
        <li><a href="leadentry.jsp">Add Lead</a></li>
        <li><a href="leads_show.jsp">Lead</a></li>
        <li><a href="team_show.jsp">Team</a></li>
        <li><a href="product_show.jsp">Product</a></li>
        <li><a href="company_show.jsp">Company</a></li>
        <li><a href="employee_show.jsp">Employees</a></li>
        <li><a href="schedule_show.jsp">Schedule</a></li>
        <li><a href="logs_show.jsp">Logs</a></li>
        <li><a href="customer_show.jsp">Customers</a></li>
        <li><a href="logout">Logout</a></li>
    </ul>
	
	<div class="container">
    <form action="Add_Schedule" method="post">
        <label for="repId">Representative ID:</label>
        <select id="repId" name="repId" required>
            <option value="">Select Representative</option>
            <% 
                RepresentativeDao repDao = new RepresentativeDao();
                List<Representative> representatives = repDao.findAll();
                for (Representative rep : representatives) {
            %>
                <option value="<%= rep.getRepID() %>"><%= rep.getRepID() %></option>
            <% } %>
        </select><br>
        
        <label for="empId">Employee ID:</label>
        <select id="empId" name="empId" required>
            <option value="">Select Employee</option>
            <% 
                EmployeeDao empDao = new EmployeeDao();
                List<Employee> employees = empDao.findAll();
                for (Employee emp : employees) {
            %>
                <option value="<%= emp.getEmpID() %>"><%= emp.getEmpID() %></option>
            <% } %>
        </select><br>
        
        <label for="interactionType">Interaction Type:</label>
        <select id="interactionType" name="interactionType" required>
            <option value="">Select Interaction Type</option>
            <option value="meeting">Meeting</option>
            <option value="call">Call</option>
            <option value="email">Email</option>
        </select><br>
        
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required><br>
        
        <label for="hour">Hour:</label>
        <select id="hour" name="hour" required>
            <% for (int i = 1; i <= 12; i++) { 
                String hour = String.format("%02d", i); // Adding leading zero if necessary
            %>
                <option value="<%= hour %>"><%= hour %></option>
            <% } %>
        </select>
        
        <label for="minute">Minute:</label>
        <select id="minute" name="minute" required>
            <option value="0">00</option>
            <option value="15">15</option>
            <option value="30">30</option>
            <option value="45">45</option>
        </select>
        
        <select name="am_pm" required>
            <option value="AM">AM</option>
            <option value="PM">PM</option>
        </select><br>
        
        <input type="submit" value="Submit">
    </form>
    </div>
    <script>
        function togglePanel() {
            var leftPanel = document.getElementById("left-panel");
            leftPanel.classList.toggle("ul-closed");
            var container = document.querySelector(".container");
            container.classList.toggle("container-closed");
        }
    </script>
</body>
</html>
