<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Reset Password</title>
     <link rel="stylesheet" type="text/css" href="resetpassword.css">
     <script>
        // JavaScript function to show alert box with the given message and redirect to forgotpassword.jsp
        function showAlertAndRedirect(message) {
            alert(message);
            window.location.href = 'login.jsp'; // Redirect to forgotpassword.jsp after displaying the message
        }
     </script>
</head>
<body>
<div class="reset-password">
<h2>Reset Password</h2>
    <form action="ResetPasswordServlet" method="post">
        <label for="newPassword">Please enter new password:</label><br>
        <input type="password" id="newPassword" name="newPassword" required><br><br>
        
        <label for="confirmPassword">Confirm password:</label><br>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
        
        <%-- Display error message if any --%>
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null && !errorMessage.isEmpty()) { %>
            <span style="color: red;"><%= errorMessage %></span>
        <% } %>
        
        <%-- Display success message if any --%>
        <% String successMessage = (String) request.getAttribute("successMessage");
           if (successMessage != null && !successMessage.isEmpty()) { %>
            <script>showAlertAndRedirect('<%= successMessage %>');</script>
        <% } %>
        <br><br>
        
        <input type="submit" value="Reset password" >
    </form>
</div>
</body>
</html>
