package com.project.client_magnet.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.client_magnet.dao.EmployeeDao;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ResetPasswordServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (email != null) {
            if (newPassword.equals(confirmPassword)) {
                try {
                    EmployeeDao edao = new EmployeeDao();
                    edao.resetPasswordMethod(email, newPassword);
                    String message = "Password reset successfully!";
                    request.setAttribute("successMessage", message);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    String errorMessage = "Failed to reset password.";
                    request.setAttribute("errorMessage", errorMessage);
                }
            } else {
                String errorMessage = "Passwords do not match!";
                request.setAttribute("errorMessage", errorMessage);
            }
        } else {
            // Redirect to forgotpassword.jsp
            String alertMessage = "Invalid access!";
            response.setContentType("text/html");
            String script = "<script>alert('" + alertMessage + "'); window.location.href = 'forgotpassword.jsp';</script>";
            response.getWriter().println(script);
            return; // Stop further execution of servlet
        }
        request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
    }
}
