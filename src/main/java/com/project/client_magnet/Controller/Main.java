package com.project.client_magnet.Controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.project.client_magnet.dao.EmployeeDao;
import com.project.client_magnet.dao.LeadDao;
import com.project.client_magnet.dao.LogsDao;
import com.project.client_magnet.dao.ScheduleDao;

public class Main {

	public static void main(String[] args) throws Exception {

//		EmployeeDao edao = new EmployeeDao();
//		System.out.println(edao.getEmpNameByEmpId(441));
//    	edao.findAll();
		
//		String hhh;
//		System.out.println(hhh);
		
//		LogsDao ldao = new LogsDao();
//		System.out.println(ldao.findAll());
//		String email = "bhavya140902@gmail.com";
//		ScheduleDao sd  = new ScheduleDao();
//		String dateTimeStr = "0001-03-24 01:00:00.0";
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		
//		    // Parse the string into a java.util.Date object
//		Date parsedDate = (Date) dateFormat.parse(dateTimeStr);
//
//		    
//		    // Convert java.util.Date to java.sql.Timestamp
//		 // Parse the string into a java.sql.Timestamp object
//		    Timestamp timestamp = Timestamp.valueOf(dateTimeStr);
//
//
//

//		System.out.println(sd.deleteOnScheduleCompleted(701,406,"email",timestamp));
		LeadDao ldao = new LeadDao();
		ldao.updateILinLead(10, 704, 406);
		
	}

}
