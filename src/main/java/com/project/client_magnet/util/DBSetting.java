package com.project.client_magnet.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBSetting {
	public static Connection getConnection() {
        Connection conn = null;

        while (conn == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project_group5","root");
            } catch (Exception E) 
            {
            	E.printStackTrace(); 
            }
        }

        return conn;
    }
}
