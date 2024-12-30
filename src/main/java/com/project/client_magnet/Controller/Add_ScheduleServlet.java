package com.project.client_magnet.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.client_magnet.dao.EmployeeDao;
import com.project.client_magnet.dao.ScheduleDao;

@WebServlet("/Add_Schedule")
public class Add_ScheduleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve other form fields
        String interactionType = request.getParameter("interactionType");
        int repId = Integer.parseInt(request.getParameter("repId"));
        int empId = Integer.parseInt(request.getParameter("empId"));
        
        PrintWriter out = response.getWriter();

        // Retrieve date, hour, minute, and AM/PM from request parameters
        String dateStr = request.getParameter("date");
        int hour = Integer.parseInt(request.getParameter("hour"));
        int minute = Integer.parseInt(request.getParameter("minute"));
        String am_pm = request.getParameter("am_pm");
//        String date = request.getParameter("date");
//        String hour = request.getParameter("hour");
//        String minute = request.getParameter("minute");
//        String am_pm = request.getParameter("am_pm");
        
        // Print the retrieved values to the console for verification
//        System.out.println("Interaction Type: " + interactionType);
//        System.out.println("Date: " + dateStr);
//        System.out.println("Hour: " + hour);
//        System.out.println("Minute: " + minute);
//        System.out.println("AM/PM: " + am_pm);
        
//        
        
      

        // Convert hour to 24-hour format if PM
        if (am_pm.equals("PM") && hour != 12) {
            hour += 12;
        } else if (am_pm.equals("AM") && hour == 12) {
            hour = 0;
        }

        // Combine date, hour, and minute into a string
        String dateTimeStr = dateStr + " " + hour + ":" + minute + ":00";

        try {
            // Parse the combined string into a java.sql.Timestamp object
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = dateFormat.parse(dateTimeStr);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

            
            ScheduleDao sdao = new ScheduleDao();
            if(sdao.addScheduleDatabase(repId, empId, interactionType,timestamp)) {
            	
            	request.getRequestDispatcher("afteradminlogin.jsp").forward(request, response);;
            }
            else {
            	  request.setAttribute("errorMessage", "Error adding schedule");
                  request.getRequestDispatcher("schedule_add.jsp").forward(request, response);
            	}
        
        
        
        } catch (ParseException e) {
            // Handle parse exception
            e.printStackTrace();
        }

        // You can add further processing logic here
        
        // Redirect or forward to another page
        // response.sendRedirect("somePage.jsp");
        // request.getRequestDispatcher("somePage.jsp").forward(request, response);
    }
}
