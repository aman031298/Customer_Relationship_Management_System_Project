package com.project.client_magnet.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.client_magnet.dao.CustomerDao;
import com.project.client_magnet.dao.LeadDao;
import com.project.client_magnet.util.DBSetting;

/**
 * Servlet implementation class LeadEntry
 */
@WebServlet("/LeadEntry")
public class LeadEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeadEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		out.println("welcome!");
		
//		
//		String companyName = request.getParameter("companyName");
//		String companyEmail = request.getParameter("companyEmail");
//		String companyAddress = request.getParameter("companyAddress");
//		String industryType = request.getParameter("industryType");
//		String source = request.getParameter("source");
//		
//		String interestLevelString = request.getParameter("interestLevel");
//		int interestLevel = Integer.parseInt(interestLevelString);
//		
//		String dealSizeString = request.getParameter("dealSize");
//		int dealSize = Integer.parseInt(dealSizeString);
//		
//		String productId = request.getParameter("productId");
//		String product = request.getParameter("product");
//		String repName = request.getParameter("repName");
//		String repEmail = request.getParameter("repEmail");
//		String mobileNo = request.getParameter("mobileNo");
//		String jobRole = request.getParameter("jobRole");
//		
//		out.println(companyName);
//		out.println(companyEmail);
//		out.println(companyAddress);
//		out.println(industryType);
//		out.println(source);
//		out.println(interestLevel);
//		out.println(dealSize);
//		out.println(productId);
//		out.println(product);
//		out.println(repName);
//		out.println(repEmail);
//		out.println(mobileNo);
//		out.println(jobRole);
		
		 // Retrieve form data
        String companyName = request.getParameter("companyName");
        
        String companyEmail = request.getParameter("companyEmail");
        
        String companyAddress = request.getParameter("companyAddress");
        
        String industryType = request.getParameter("industryType");
        
        String source = request.getParameter("source");
        
        int interestLevel = Integer.parseInt(request.getParameter("interestLevel"));
        
        int dealSize = Integer.parseInt(request.getParameter("dealSize"));
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        String product = request.getParameter("product");
        
        String repName = request.getParameter("repName");
        
        String repEmail = request.getParameter("repEmail");
        
        String repMobile = request.getParameter("mobileNo");
        
        String jobRole = request.getParameter("jobRole");

        
        
        if (interestLevel==10) {
        	CustomerDao cdao = new CustomerDao();
        	if(cdao.addLeadDirectToCustomer(companyName,productId,industryType,companyAddress,companyEmail)) {
        		 request.getRequestDispatcher("afteradminlogin.jsp").forward(request, response);;
        	}
        	else {
                request.setAttribute("errorMessage", "Error inserting data");
                request.getRequestDispatcher("leadentry.jsp").forward(request, response);
            }
        	
        }
        else {
        	LeadDao ldao = new LeadDao();
        	if(ldao.addToLeadCompanyRep(companyName,companyEmail,companyAddress,industryType,source,interestLevel,dealSize,productId,product,repName,repEmail,repMobile,jobRole)) {
        		request.getRequestDispatcher("afteradminlogin.jsp").forward(request, response);;
        	}
        	else {
        		request.setAttribute("errorMessage", "Error inserting data");
                request.getRequestDispatcher("leadentry.jsp").forward(request, response);
        	}
        }
        // Database connection
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            // Establish database connection
//            conn = DBSetting.getConnection();
//
//            // Insert data into Company table
//           
//            pstmt = conn.prepareStatement("INSERT INTO Company (Cname, Address, Email) VALUES (?, ?, ?)");
//            pstmt.setString(1, companyName);
//            pstmt.setString(2, companyAddress);
//            pstmt.setString(3, companyEmail);
//            pstmt.executeUpdate();
//
//            // Retrieve generated CID
////            out.print("Hello");
//            pstmt = conn.prepareStatement("SELECT CID FROM Company WHERE Cname = ?");
//            pstmt.setString(1, companyName);
//            ResultSet rs = pstmt.executeQuery();
//            rs.next();
//            int companyId = rs.getInt(1);
////            out.print(companyId);
//            // Insert data into Representative table
//            pstmt = conn.prepareStatement("INSERT INTO Representative (RepName, CID, RepEmail, RepMobile, JobRole) VALUES (?, ?, ?, ?, ?)");
//            pstmt.setString(1, repName);
//            pstmt.setInt(2, companyId);
//            pstmt.setString(3, repEmail);
//            pstmt.setString(4, repMobile);
//            pstmt.setString(5, jobRole);
//            pstmt.executeUpdate();
//            out.print("Hello");
//            // Retrieve generated RepID
//            pstmt = conn.prepareStatement("SELECT RepID FROM Representative WHERE RepName = ?");
//            pstmt.setString(1, repName);
//            rs = pstmt.executeQuery();
//            rs.next();
//            int repId = rs.getInt(1);
//            
//            //Insert data into Product table
////            pstmt = conn.prepareStatement("select * from product where productId = ?");
////            pstmt.setInt(1, productId);
////            rs=pstmt.executeQuery();
////            rs.next();
////            int teamId = rs.getInt(3);
////            pstmt = conn.prepareStatement("INSERT INTO Product (ProductID, ProductName, TeamID) VALUES (?, ?, ?)");
////            pstmt.setInt(1, productId);
////            pstmt.setString(2, product);
////            pstmt.setInt(3, teamId);
////            pstmt.executeQuery();
//
//            // Insert data into Lead table
//            pstmt = conn.prepareStatement("INSERT INTO Lead (CID, ProductID, IndustryType, Source, InterestLevel, DealSize, RepID) VALUES (?, ?, ?, ?, ?, ?, ?)");
//            pstmt.setInt(1, companyId);
//            pstmt.setInt(2, productId);
//            pstmt.setString(3, industryType);
//            pstmt.setString(4, source);
//            pstmt.setInt(5, interestLevel);
//            pstmt.setBigDecimal(6, dealSize);
//            pstmt.setInt(7, repId);
//            pstmt.executeUpdate();
//            
//            out.print("byebye");
//
//            request.getRequestDispatcher("afteradminlogin.jsp");
//        	} catch (SQLException e) 
//        {
//            e.printStackTrace();
//            response.getWriter().println("Error inserting data.");
//        } 
//        finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
	}

}
