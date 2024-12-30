<%@ page import="com.project.client_magnet.dao.ProductDao" %>
<%@ page import="com.project.client_magnet.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        body {
            background-color: #222;
            color: #fff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        /* Styles for the top header */
        .top-header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
            line-height: 40px;
            position: relative;
        }

        /* Styles for the logout button */
        .logout-button {
            position: absolute;
            top: 20px;
            right: 20px;
            color: #fff;
            text-decoration: none;
            border: 1px solid #fff;
            padding: 5px 10px;
            border-radius: 5px;
        }

        .logout-button:hover {
            background-color: #555;
        }

       /* Styles for the left panel */
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
    <div class="top-header">
        <button class="toggle-button" onclick="togglePanel()">&#9776;</button>
        <span class="welcome-message">Welcome</span>
        <a href="logout.jsp" class="logout-button">Logout</a>
    </div>

    <ul id="left-panel" class="ul-closed">
        
        <li><a href="leads_show.jsp">Lead</a></li>
        <li><a href="team_show.jsp">Team</a></li>
        <li><a href="product_show.jsp">Product</a></li>
        <li><a href="company_show.jsp">Company</a></li>
       
        <li><a href="schedule_show.jsp">Schedule</a></li>
        <li><a href="logs_show.jsp">Logs</a></li>
        <li><a href="customer_show.jsp">Customers</a></li>
        <li><a href="logout">Logout</a></li>
    </ul>

    <div class="container">
        <% 
        ProductDao pdao = new ProductDao();
        List<Product> products = pdao.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String backgroundImage = "url('image" + (i % 4 + 1) + ".png')"; 
        %>
        <div class="card" style="background-image: <%= backgroundImage %>;">
           <h3 style="color: black;"><%= product.getProductName() %></h3>

            <div class="card-content">
                <p>ProductID: <%= product.getProductID() %></p>
                <p>TeamID: <%= product.getTeam().getTeamId() %></p>
                <!-- Add more product details here -->
            </div>
        </div>
        <% } %>
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
