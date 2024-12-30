package com.project.client_magnet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.client_magnet.dao.LeadDao;

@WebServlet("/deleteLeadServlet")
public class DeleteLeadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve lead ID and other column values from request parameters
    	
    	PrintWriter out = response.getWriter();
    	
        String leadIdString = request.getParameter("leadId");
        int leadId =Integer.parseInt(leadIdString);
//        String companyId = request.getParameter("companyId");
//        String productId = request.getParameter("productId");
//        String industry = request.getParameter("industry");
//        String source = request.getParameter("source");
//        String interestLevel = request.getParameter("interestLevel");
//        String dealSize = request.getParameter("dealSize");
//        String representativeId = request.getParameter("representativeId");

        // Perform deletion logic using these values
        // Example: Deleting the lead from the database
        // LeadDao.deleteLead(leadId);
        
      LeadDao ldao = new LeadDao();
      try {
		if(ldao.delete(leadId)) {
			response.sendRedirect("leads_show.jsp");
		}
		else {
			request.setAttribute("errorMessage", "Error deleting lead");
            request.getRequestDispatcher("leads_show.jsp").forward(request, response);

		}
		
	} catch (Exception e) {


        e.printStackTrace();
        request.setAttribute("errorMessage", "Error deleting lead");
        request.getRequestDispatcher("leads_show.jsp").forward(request, response);
    
		
	}
        
        // Redirect to another page after deletion
//        response.sendRedirect("leads_show.jsp");
    }
}
