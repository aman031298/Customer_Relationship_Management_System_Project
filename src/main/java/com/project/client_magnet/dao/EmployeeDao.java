//package com.project.client_magnet.dao;
//
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.project.client_magnet.dao.TeamDao;
//import com.project.client_magnet.model.Employee;
//import com.project.client_magnet.model.Team;
//import com.project.client_magnet.util.DBConnection;
//import com.project.client_magnet.util.DBSetting;
//
//public class EmployeeDao implements IDao<Employee> {
//	Connection connection=null;
//	private List<Employee> employees = new ArrayList<>();
//
//	public EmployeeDao() {
//		super();
//
//	}
//
////	public EmployeeDao(DBConnection dbConnection) {
////		super();
////		this.dbConnection = dbConnection;
////	}
//	

//	public boolean loginUser(String email, String password) throws Exception{
//	    boolean flag = false;
////        System.out.println(11);
////        System.out.println(11);
////        System.out.println(11);
////        System.out.println(11);
////        System.out.println(11);
//	   
//	        new DBSetting();
//			connection=DBSetting.getConnection();
//	       
//	        if (connection != null) { // Check for null connection
//	            String query = "select * from employee where email=? and password=?";
//	            PreparedStatement ps = connection.prepareStatement(query);
////	            System.out.println("dddddddddddddddddddddddddddddddddddddddddddefffff");
//	            ps.setString(1,email);
//	            ps.setString(2,password);
//	            ResultSet rs = ps.executeQuery();
//	            if(rs.next()){
//	                flag = true;
//	            }
//	            connection.close();
//	 
//	    }
//	    return flag;
//	}
//	

	

//	@Override
//	public Employee create(Employee t) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean update(int id, Employee t) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean delete(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Employee findOne(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> findAll() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public Employee create(Employee employee) {
////		try {
////new DBSetting();
////			//			Connection connection = dbConnection.getConnection();
////			connection=DBSetting.getConnection();
////			String sqlQuery = "insert into employee (EmpName,TeamId,Email,mobile,Password) values(?,?,?,?,?)";
////
////			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
////			preparedStatement.setString(1, employee.getEmpName());
////			preparedStatement.setInt(2, employee.getTeam().getTeamId());
////			preparedStatement.setString(3, employee.getEmail());
////			preparedStatement.setString(4, employee.getMobile());
////			preparedStatement.setString(5, employee.getPassword());
////
////			if (preparedStatement.executeUpdate() < 0) {
////				employee = null;
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////
////		return employee;
////	}
////    public boolean addPassword(String ypassword,String yemail){
////        boolean flag = false;
////        try{
////new DBSetting();
////			//        	Connection connection = dbConnection.getConnection();
////        	connection=DBSetting.getConnection();
////        	String query = "UPDATE Employee SET password=? where email=?";
////            PreparedStatement ps =connection.prepareStatement(query);
////            ps.setString(1,ypassword);
////            ps.setString(2,yemail);
////            ps.executeUpdate();
////            connection.close();
////            flag = true;
////        }catch(SQLException e){
////            e.printStackTrace();
////        }
////        return flag;
////    }
////
////	@Override
////	public boolean update(int id, Employee employee) {
////		boolean result = false;
////		try {
////new DBSetting();
////			//			Connection connection = dbConnection.getConnection();
////			connection=DBSetting.getConnection();
////			String sqlQuery = "update Employee set email = ? where empId = ?";
////			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
////			preparedStatement.setString(1, employee.getEmail());
//////			preparedStatement.setInt(2, employee.getTeam().getTeamId());
////			preparedStatement.setInt(2, id);
////			if (preparedStatement.executeUpdate() > 0) {
////				result = true;
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return result;
////	}
////
////	@Override
////	public boolean delete(int id) throws Exception {
////		boolean result = false;
////		try {
////new DBSetting();
////			//			Connection connection = dbConnection.getConnection();
////			connection=DBSetting.getConnection();
////			String sqlQuery = "Delete from employee where empId = ?";
////			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
////			preparedStatement.setInt(1, id);
////			if (preparedStatement.executeUpdate() > 0) {
////				result = true;
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return result;
////	}
////
////	@Override
////	public Employee findOne(int id) throws Exception {
////		boolean result = false;
////		try {
////new DBSetting();
////			//			Connection connection = dbConnection.getConnection();
////			connection=DBSetting.getConnection();
////			final String sqlQuery = "Select EmpId,EmpName,TeamId,Email,mobile,Password from Employee where empId = ?";
////			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
////			preparedStatement.setInt(1, id);
//////			int teamid = preparedStatement.getInt(3);
////			ResultSet resultSet = preparedStatement.executeQuery();
////			Employee employee = null;
////			if(resultSet.next()) {
////				int teamid = resultSet.getInt(3);
////				TeamDao td = new TeamDao(dbConnection);
////				Team team = td.findOne(teamid);
////				employee = new Employee(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),team,resultSet.getString(6));
////				return  employee;
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return null;
////	}
//	public boolean addPassword(String ypassword, String yemail) {
//		boolean flag = false;
//		try {
//			connection = DBSetting.getConnection();
//			String query = "UPDATE Employee SET password=? where email=?";
//			PreparedStatement ps = connection.prepareStatement(query);
//			ps.setString(1, ypassword);
//			ps.setString(2, yemail);
//			ps.executeUpdate();
//			connection.close();
//			flag = true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}

////
////	@Override
////	public List<Employee> findAll() throws Exception {
////		boolean result = false;
////		try {
////new DBSetting();
////			//			Connection connection = dbConnection.getConnection();
////			connection=DBSetting.getConnection();
////			Statement selectStatement = connection.createStatement();
////			final String sqlQuery = "Select * from Employee";
////			ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
////
////			while (resultSet.next()) {
////				int teamid = resultSet.getInt(3);
//////				TeamDao td = new TeamDao(dbConnection);
////			Team team = null ;
//////				td.findOne(teamid);
////
////			Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),team,resultSet.getString(6));
////				System.out.println(employee);
////				employees.add(employee);
////
////			}
////			if (employees.isEmpty())
////				return null;
////			return employees;
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return employees;
////	}
//
//

package com.project.client_magnet.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.dao.TeamDao;
import com.project.client_magnet.model.Employee;
import com.project.client_magnet.model.Team;
//import com.project.client_magnet.util.DBConnection;
import com.project.client_magnet.util.DBSetting;

public class EmployeeDao implements IDao<Employee> {
	Connection connection = null;
	private List<Employee> employees = new ArrayList<>();

	public EmployeeDao() {
		super();

	}
	
//	   // SQL query to select all employees
//    private static final String SELECT_ALL_EMPLOYEES_QUERY = "SELECT * FROM Employee";
//    public static ArrayList<Employee> getEmployees()  {
//        ArrayList<Employee> employees = new ArrayList<>();
//
//         new DBSetting();
//		 connection=DBSetting.getConnection(); 
//		 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_QUERY);
//         ResultSet resultSet = preparedStatement.executeQuery()
//
//            while (resultSet.next()) {
//                // Retrieve employee data from the result set
//                int empID = resultSet.getInt("EmpID");
//                String empName = resultSet.getString("EmpName");
//                int teamID = resultSet.getInt("TeamID");
//                String email = resultSet.getString("Email");
//                String mobile = resultSet.getString("Mobile");
//                String password = resultSet.getString("Password");
//                
//                
//
//                // Create an Employee object
//                Employee employee = new Employee(empID, empName, teamID, email, mobile, password);
//
//                // Add the employee to the list
//                employees.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return employees;
//    }
//
//    // You can similarly implement a method to fetch representatives using a similar approach
//    // Just replace the SQL query and column names accordingly
//}
    

	public String getEmpNameByEmpId(int id) throws Exception {
		
		String empName = null ;
		connection=DBSetting.getConnection();
	       
        if (connection != null) { // Check for null connection
            String query = "select empname from employee where empid=?";
            PreparedStatement ps = connection.prepareStatement(query);
//            System.out.println("dddddddddddddddddddddddddddddddddddddddddddefffff");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
              
                 empName = rs.getString(1);
            }
            
            connection.close();
 
    }
    return empName;
}
	
	public  void resetPasswordMethod(String email, String password) throws Exception{
//	    boolean flag = false;
//        System.out.println(11);
//        System.out.println(11);
//        System.out.println(11);
//        System.out.println(11);
//        System.out.println(11);
	   
	        new DBSetting();
			connection=DBSetting.getConnection();
//			boolean flag= false;
	       
	        if (connection != null) { // Check for null connection
	            String query = "update employee set password=? where email=?";
	            PreparedStatement ps = connection.prepareStatement(query);
//	            System.out.println("dddddddddddddddddddddddddddddddddddddddddddefffff");
	            ps.setString(1,password);
	            ps.setString(2,email);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
//	                flag = true;
	            	System.out.println("Password updated");
	            }
	            connection.close();
	 
	    }
	   
	}
	
	public boolean findByEmailId(String email) throws Exception {
		boolean flag= false;
		connection=DBSetting.getConnection();
	       
        if (connection != null) { // Check for null connection
            String query = "select * from employee where email=?";
            PreparedStatement ps = connection.prepareStatement(query);
//            System.out.println("dddddddddddddddddddddddddddddddddddddddddddefffff");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
            connection.close();
 
    }
    return flag;
		
		
	}

	public boolean loginUser(String email, String password) throws Exception {
		boolean flag = false;

		new DBSetting();
		connection = DBSetting.getConnection();

		if (connection != null) { // Check for null connection
			String query = "select * from employee where email=? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			connection.close();

		}
		return flag;
	}

	@Override
	public Employee create(Employee employee) {
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into employee (EmpName,TeamId,Email,mobile,Password) values(?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getTeam().getTeamId());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getMobile());
			preparedStatement.setString(5, employee.getPassword());

			if (preparedStatement.executeUpdate() < 0) {
				employee = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}


	@Override
	public boolean update(int id, Employee employee) {
		boolean result = false;
		try {

			connection = DBSetting.getConnection();
			String sqlQuery = "update Employee set email = ? where empId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, employee.getEmail());
//			preparedStatement.setInt(2, employee.getTeam().getTeamId());
			preparedStatement.setInt(2, id);
			if (preparedStatement.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean result = false;
		try {

			connection = DBSetting.getConnection();
			String sqlQuery = "Delete from employee where empId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee findOne(int id) throws Exception {
		boolean result = false;
		try {

			connection = DBSetting.getConnection();
			final String sqlQuery = "Select EmpId,EmpName,TeamId,Email,mobile,Password from Employee where empId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, id);
//			int teamid = preparedStatement.getInt(3);
			ResultSet resultSet = preparedStatement.executeQuery();
			Employee employee = null;
			if (resultSet.next()) {
				int teamid = resultSet.getInt(3);
				TeamDao td = new TeamDao();
				Team team = td.findOne(teamid);
				employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), team, resultSet.getString(6));
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		boolean result = false;
		try {

			connection = DBSetting.getConnection();
			Statement selectStatement = connection.createStatement();
			final String sqlQuery = "Select * from Employee";
			ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int teamid = resultSet.getInt(3);
				TeamDao td = new TeamDao();
				Team team = null;
				team=td.findOne(teamid);

				Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4),
						resultSet.getString(5), team, resultSet.getString(6));
				System.out.println(employee);
				employees.add(employee);

			}
			if (employees.isEmpty())
				return null;
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
