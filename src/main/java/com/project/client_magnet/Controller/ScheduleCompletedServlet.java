package com.project.client_magnet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.client_magnet.dao.LeadDao;
import com.project.client_magnet.dao.LogsDao;
import com.project.client_magnet.dao.ScheduleDao;

@WebServlet("/TransferServlet")
public class ScheduleCompletedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
    	System.out.println("hii");
    	PrintWriter out = response.getWriter();
    	int rowCount = Integer.parseInt(request.getParameter("rowCount"));
        
        for (int i = 1; i < rowCount; i++) {
        	System.out.println("inside ");
            String status = request.getParameter("status_" + i);
            System.out.println(status);

            String repIDString = request.getParameter("repID_" + i);
            int repID = Integer.parseInt(repIDString);
            System.out.println(repID);
           
            String empIDString = request.getParameter("empID_" + i);
            int empID = Integer.parseInt(empIDString);
            String interactionType = request.getParameter("interactionType_" + i);
            
            String dateStr = request.getParameter("date_" + i);
            String timeStr = request.getParameter("time_" + i);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
            java.util.Date dateUtil;
            try {
                // Parse the string into a java.util.Date object
                dateUtil = formatter.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle parsing error
                return;
            }

            // Convert java.util.Date to java.sql.Date
            java.sql.Date date = new java.sql.Date(dateUtil.getTime());
            
            String dateTimeStr = dateStr + " " + timeStr;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp;
            try {
                java.util.Date parsedDate = dateFormat.parse(dateTimeStr);
                timestamp = new Timestamp(parsedDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                // Handle parsing error
                return;
            }
//            String datei = request.getParameter("date_" + i);
//            
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
//            Date date;
//            try {
//                date = (Date) formatter.parse(datei); // Parse the string into a Date object
//            } catch (ParseException e) {
//                e.printStackTrace();
//                // Handle parsing error
//                return;
//            }
            
            // Check if status is completed
            if ("Completed".equals(status)) {
                // Transfer data to another table or perform desired action
//            	out.println(repID);
//            	out.println(empID);
//            	out.println(interactionType);
//            	out.println(date);
//            	out.println(status);
            	
            	
            	 String interestLevelString = request.getParameter("interestLevel_" + i);
            	 int interestLevel = Integer.parseInt(interestLevelString);
            	 
            	 
            	 
                 String interactionSummary = request.getParameter("interactionSummary_" + i);
//                 out.println("Interest Level: " + interestLevel);
//                 out.println("Interaction Summary: " + interactionSummary);
                 
                
                 System.out.println(repID);
                 System.out.println(empID);
                 System.out.println(interactionType);
                 System.out.println(timestamp);


                LeadDao leaddao = new LeadDao();
                try {
					leaddao.updateILinLead(interestLevel,repID,empID);
					System.out.println("success");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
                LogsDao ldao = new LogsDao();
                if(ldao.addfromSchedule(repID,empID,interactionType,date,interactionSummary)) {
                	ScheduleDao sdao = new ScheduleDao();
                    if(sdao.deleteOnScheduleCompleted(repID,empID,interactionType)) {
                    	request.getRequestDispatcher("schedule_show_employee.jsp").forward(request, response);
                    }
                    else {
                    	System.out.println("Unsuccessful");
                    }
                }
                else {
                	System.out.println("Unsuccessful");
                }
            }
        }
    }
}