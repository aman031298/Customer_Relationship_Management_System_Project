package com.project.client_magnet.Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.client_magnet.dao.EmployeeDao;



///////
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
//		res.sendRedirect("login.jsp");
//	}
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out=res.getWriter();		
//		out.println("hello world");
		
//		HttpSession session = req.getSession();
//		DBConnection dbc = DBConnection.getDbConnection();
//		System.out.println("get fdb con"+dbc);//---------
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
//		out.println(email);
//		Employee emp = new Employee(email,password);
//		EmployeeDao e = new EmployeeDao(dbConnection);
		
//		EmployeeDao emp = new EmployeeDao(dbc);
		
//		if(emp.loginUser(email,password)) {
//			if(email.equals("salesRep2024@gmail.com")) {
//				System.out.println("true-loginServlet.java");
//				emp.setSeller("1");
//				session.setAttribute("FinalyNewUser",emp);
//                session.setAttribute("email",email);
//                res.sendRedirect("next.jsp?seller=1");
//			}else{
//                System.out.println("true-loginServlet.java");
//                session.setAttribute("FinalyNewUser",emp);
//                session.setAttribute("email",email);
//                res.sendRedirect("next.jsp");
//            }
//		}else{
//            res.sendRedirect("newaccount.jsp");
//        }
		///////////////////////////////////////////////////////////////////////////////////////////
		boolean flag=false;
		try
		{
		flag=new EmployeeDao().loginUser(email, password);
//		out.print(flag);
			if (flag) {
				HttpSession session = req.getSession();
				session.setAttribute("email", email);
				if(email.equals("disharajak2002@gmail.com")){
				req.getRequestDispatcher("afteradminlogin.jsp").forward(req, res);
				}
				else {
					req.getRequestDispatcher("afteremployeelogin.jsp").forward(req, res);
				}
			}
			else {
				req.setAttribute("errorMessage", "Invalid username or passsword");
		         req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/////////////////////////////////////////////////////////////////////
	
		
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		} 
//     Connection conn=null;
//	try {
//		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project_group5","root");
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//     PreparedStatement pstmt=null;
//     ResultSet rs=null;
//     
//     try {
//		pstmt = conn.prepareStatement("select * from employee where email=? and password=?");
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//     try {
//		pstmt.setString(1, email);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//     try {
//		pstmt.setString(2, password);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//     try {
//		if (pstmt.execute()) {
//		     rs = pstmt.getResultSet();
//		 }
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	};
//     try {
//		if (rs.next()) {
//		     flag=true;
//		 }
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
     
	    
	

//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		
		
		
		//			try {
//				System.out.println(emp.loginUser(email, password));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println("Catch");
//				e.printStackTrace();
//				
//			}
//		String recipientEmail = request.getParameter("recipient_email");
//        String subject = "fffff";
//        String body = "Hii";
//
//        try {
//            EmailUtility.sendEmail(email, subject, body);
//            res.getWriter().println("Email sent successfully");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            res.getWriter().println("Failed to send email. Please try again later.");
//        }
		
		
//		 SendEmail.sendEmail();
//		System.out.println("dddddddddddddddddddddddddwdwdwdrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		
	}
	
}