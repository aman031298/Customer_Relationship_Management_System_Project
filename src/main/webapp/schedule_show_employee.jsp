<%@ page import="com.project.client_magnet.model.Schedule" %>
<%@ page import="com.project.client_magnet.dao.ScheduleDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies
%>
<!DOCTYPE html>
<html>
<head>
    <title>Schedule</title>
  <script>
    function showPromptBox(row) {
        var interestLevel;
        do {
            interestLevel = prompt("Enter Interest Level (1-10):");
            if (interestLevel === null) {
                // User canceled, exit the function
                return;
            }
            interestLevel = parseInt(interestLevel); // Convert to integer
        } while (isNaN(interestLevel) || interestLevel < 1 || interestLevel > 10);

        var interactionSummary = prompt("Enter Interaction Summary:");
        if (interactionSummary !== null) {
            document.getElementById("interestLevel_" + row).value = interestLevel;
            document.getElementById("interactionSummary_" + row).value = interactionSummary;
            document.getElementById("scheduleForm").submit();
        }
    }
</script>

</head>
<body>
    <h1>Schedule List</h1>
    <form id="scheduleForm" action="TransferServlet" method="post">
        <table border="1">
            <tr>
                <th>  </th>
                <th>RepID</th>
                <th>EmpID</th>
                <th>InteractionType</th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
            </tr>
            <% 
            String email = (String)session.getAttribute("email");
            ScheduleDao sdao = new ScheduleDao();
            List<Schedule> schedules = sdao.findAllforEmployee(email);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy");
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
            int rowNum = 1; 
            if(schedules==null){
        		request.getRequestDispatcher("empty_schedule_show_employee.jsp").forward(request, response);
        	}
            else{
            for (Schedule schedule : schedules) {
            	
            	
                java.sql.Timestamp timestamp = schedule.getPreferredTime();
                String dateStr = dateFormatter.format(timestamp);
                String timeStr = timeFormatter.format(timestamp);
            %>
            <tr>
                <td><%= rowNum %></td> 
                <td><%= schedule.getRepresentative().getRepID() %></td>
                <td><%= schedule.getEmployee().getEmpID() %></td>
                <td><%= schedule.getInteractionType() %></td>
                <td><%= dateStr %></td>
                <td><%= timeStr %></td>
                <td>
                    <select name="status_<%= rowNum %>" onchange="showPromptBox(<%= rowNum %>)">
                        <option value="Pending">Pending</option>
                        <option value="Completed">Completed</option>
                    </select>
                    
                    <input type="hidden" name="repID_<%= rowNum %>" value="<%= schedule.getRepresentative().getRepID() %>">
                    <input type="hidden" name="empID_<%= rowNum %>" value="<%= schedule.getEmployee().getEmpID() %>">
                    <input type="hidden" name="interactionType_<%= rowNum %>" value="<%= schedule.getInteractionType()  %>">
                    <input type="hidden" name="date_<%= rowNum %>" value="<%= dateStr %>">
                    <input type="hidden" name="time_<%= rowNum %>" value="<%= timeStr %>">
                    <input type="hidden" id="interestLevel_<%= rowNum %>" name="interestLevel_<%= rowNum %>" value="">
                    <input type="hidden" id="interactionSummary_<%= rowNum %>" name="interactionSummary_<%= rowNum %>" value="">
                    
                </td>
                
            </tr>
          	<%= rowNum++ %>
            <% }} %>
		
            
        </table>
        <input type="hidden" name="rowCount" value="<%= rowNum %>">
        
    </form>
</body>
</html>