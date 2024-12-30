<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ClientMagnet</title>
    <link rel="stylesheet" href="home.css">
    <style>
        body {
            background-image: url('download.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>
    <nav>
        <div class="menu">
            <div class="logo">
                <a href="#"><img src="project_logo.png" alt="Logo">ClientMagnet</a>
            </div>
            <ul>
                <li><a href="home.jsp">Home</a></li>
               <!-- <li><a href="lead.html">About</a></li> --> 
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
       
 <div class="center">
            <h1 class="title">Customer relationship management is not a strategy, it's a philosophy.</h1>
        </div> 
        
    </div>
</body>
</html>