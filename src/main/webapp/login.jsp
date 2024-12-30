<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies
%>

<%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		cookie.setMaxAge(0); // Clear cookie by setting max age to 0
		response.addCookie(cookie);
	}
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
    <style>
        body {
    background-image: url('download.jpg');
    background-size: cover;
    background-position: center;
    height: 100vh;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login-container {
    background-color: white; /* Change background color to white */
    padding: 40px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 400px;
    width: 100%;
}

        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 3px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .btn-login {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .btn-login:hover {
            background-color: #0056b3;
        }
        .extra-options {
            margin-top: 10px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
    </style>
    <script>
        <%-- JavaScript function to display an alert box --%>
        function showAlert(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login.do" method="post">
            <div class="input-group">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <% String errorMessage = (String) request.getAttribute("errorMessage");
               if (errorMessage != null && !errorMessage.isEmpty()) { %>
                <%-- JavaScript code to call showAlert function when there's an error message --%>
                <script>
                    showAlert("<%= errorMessage %>");
                </script>
            <% } %>
            <div class="input-group">
                <input type="submit" value="Login" class="btn-login">
            </div>
        </form>
        <div class="extra-options">
            <a href="forgotpassword.jsp">Forgot Password?</a>
        </div>
    </div>
</body>
</html>
