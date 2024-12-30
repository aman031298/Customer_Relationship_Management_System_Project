//package com.project.client_magnet.Controller;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpSession;
//
//import com.project.client_magnet.dao.EmployeeDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////import jakarta.servlet.http.HttpSession;
//
//import javax.mail.MessagingException;
//
//@WebServlet("/ForgotPasswordServlet")
//public class ForgotPasswordServlet extends HttpServlet {
////    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        
//     // In the source servlet
//        HttpSession session = request.getSession();
//        session.setAttribute("email", email);
//
//
//        
//        PrintWriter out=response.getWriter();
//        
//        // Generate a random password reset token (you can implement your own logic for this)
////        String resetToken = generateRandomToken();
//        
//        // Send an email with the reset token
////        try {
////            sendPasswordResetEmail(recipientEmail, resetToken);
////            response.sendRedirect("passwordResetSuccess.jsp");
////        } catch (MessagingException e) {
////            e.printStackTrace();
////            response.sendRedirect("passwordResetError.jsp");
////        }
////    }
////
////    private String generateRandomToken() {
////        // Implement your logic to generate a random token
////        // For demonstration purposes, let's say it generates a random 6-character alphanumeric string
////        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
////        StringBuilder token = new StringBuilder();
////        for (int i = 0; i < 6; i++) {
////            int index = (int) (Math.random() * characters.length());
////            token.append(characters.charAt(index));
////        }
////        return token.toString();
////    }
////
////    private void sendPasswordResetEmail(String recipientEmail, String resetToken) throws MessagingException {
////        // Implement sending email logic using EmailUtility class from the previous example
////        // You need to fill in the method with appropriate details like sender email, subject, etc.
////        // EmailUtility.sendEmail(recipientEmail, "Password Reset", "Your password reset token is: " + resetToken);
////        // Replace the above line with your email sending logic
////    	
//      String subject = "Life changing advice";
//      String body = "Click here to reset your password: 'http://localhost:8080/Project_CRM/resetpassword.jsp'";
////
//      try {
//    	  EmployeeDao edao = new EmployeeDao();
//    	  if(edao.findByEmailId(email)) {
//    		  EmailUtility.sendEmail(email, subject, body);
//              response.getWriter().println("Email sent successfully");
//    	  }
//    	  else {
//    		  out.println("Employee does not exist");
//    	  }
////          EmailUtility.sendEmail(email, subject, body);
////          response.getWriter().println("Email sent successfully");
//      } catch (Exception e) {
//          e.printStackTrace();
//          response.getWriter().println("Failed to send email. Please try again later.");
//      }
//    	
//    	
//    }
//}

package com.project.client_magnet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.client_magnet.dao.EmployeeDao;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        
        // In the source servlet
        request.getSession().setAttribute("email", email);

        // Attempt to send the email
        String subject = "Life changing advice";
        String body = "Click here to reset your password: 'http://localhost:8080/Project_CRM/resetpassword.jsp'";

        try {
            EmployeeDao edao = new EmployeeDao();
            if (edao.findByEmailId(email)) {
                EmailUtility.sendEmail(email, subject, body);
                request.setAttribute("emailSentMessage", "Email sent successfully");
            } else {
                request.setAttribute("emailSentMessage", "Employee does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("emailSentMessage", "Failed to send email. Please try again later.");
        }
        
        // Redirect back to forgotpassword.jsp
        request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
    }
}

