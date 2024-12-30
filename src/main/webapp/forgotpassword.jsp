<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script>
        function showAlert(message) {
            alert(message);
        }
    </script>
</head>
<style>
body {
    background-image: url('download.jpg'); /* Add background image */
    background-size: cover;
    background-position: center;
    height: 100vh;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
<body>
    <div class="forgot-password-container">
        <h2>Forgot Password</h2>
        <p>Please enter your email address to reset your password.</p>
        <form action="ForgotPasswordServlet" method="post">
            <div class="input-group" id='resetLink'>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <% String emailSentMessage = (String) request.getAttribute("emailSentMessage");
               if (emailSentMessage != null && !emailSentMessage.isEmpty()) { %>
                <script>
                    showAlert("<%= emailSentMessage %>");
                </script>
            <% } %>
            <div class="input-group">
                <input type="submit" value="Send Mail" class="btn-reset" >
            </div>
        </form>
    </div>
</body>
</html>