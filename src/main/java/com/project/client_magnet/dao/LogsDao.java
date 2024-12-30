//package com.project.client_magnet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.project.client_magnet.dao.EmployeeDao;
//import com.project.client_magnet.dao.IDao;
//import com.project.client_magnet.dao.RepresentativeDao;
//import com.project.client_magnet.model.Employee;
//import com.project.client_magnet.model.Logs;
//import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.util.DBConnection;
//
//public class LogsDao implements IDao<Logs> {
//	private DBConnection dbConnection;
//	private List<Logs> Log = new ArrayList<>();
//
//	public LogsDao() {
//		super();
//	}
//
//	public LogsDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	@Override
//	public Logs create(Logs Logs) {
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "insert into  Logs(RepID,EmpID,InteractionType,Date,Notes) values(?,?,?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, Logs.getRepresentative().getRepID());
//			preparedStatement.setInt(2, Logs.getEmployee().getEmpID());
//			preparedStatement.setString(3, Logs.getInteractionType());
//			preparedStatement.setDate(4, Logs.getDates());
//			preparedStatement.setString(5, Logs.getNotes());
//			if (preparedStatement.executeUpdate() < 0) {
//				Logs = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return Logs;
//	}
//
//	@Override
//	public boolean update(int id, Logs t) {
//		boolean result = false;
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "update Logs set InteractionType=?, Date=?, Notes=? where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, t.getInteractionType());
//			preparedStatement.setDate(4, t.getDates());
//			preparedStatement.setString(3, t.getNotes());
//			preparedStatement.setInt(1, id);
//			if (preparedStatement.executeUpdate() > 0) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	@Override
//	public boolean delete(int id) {
//		boolean result = false;
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "delete from Logs where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, id);
//			if (preparedStatement.executeUpdate() > 0) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	@Override
//	public Logs findOne(int id) throws Exception {
//		try {
//			Connection connection = dbConnection.getConnection();
//			final String sqlQuery = "Select RepID,EmpID,InteractionType,Date,Notes from Logs where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			Logs Logs = null;
//			if (resultSet.next()) {
//				int employeeId = resultSet.getInt(2);
//				EmployeeDao employeeDao = new EmployeeDao(dbConnection);
//				Employee employee;
//				
//					employee = employeeDao.findOne(employeeId);
//				int representativeId = resultSet.getInt(2);
//				RepresentativeDao representativeDao = new RepresentativeDao(dbConnection);
//				Representative representative = representativeDao.findOne(representativeId);
//
//				Logs = new Logs(representative, employee, resultSet.getString(3), resultSet.getDate(4),
//						resultSet.getString(5));
//			}
//
//			return Logs;
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Logs> findAll() throws Exception {
//
//		try {
//			Connection connection = dbConnection.getConnection();
//			Statement selectStatement = connection.createStatement();
//
//			final String sqlQuery = "select * from Logs";
//			ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//			while (resultSet.next()) {
//				int employeeId = resultSet.getInt(2);
//				EmployeeDao employeeDao = new EmployeeDao(dbConnection);
//				Employee employee = employeeDao.findOne(employeeId);
//				int representativeId = resultSet.getInt(2);
//				RepresentativeDao representativeDao = new RepresentativeDao(dbConnection);
//				Representative representative = representativeDao.findOne(representativeId);
//
//				Logs Logs = new Logs(representative, employee,resultSet.getString(3),resultSet.getDate(4),resultSet.getString(5));
//				System.out.println(Logs);
//				Log.add(Logs);
//
//			}
//			if (Log.isEmpty())
//				return null;
//			return Log;
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}	
//}

package com.project.client_magnet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.dao.EmployeeDao;
import com.project.client_magnet.dao.IDao;
import com.project.client_magnet.dao.RepresentativeDao;
import com.project.client_magnet.model.Employee;
import com.project.client_magnet.model.Logs;
import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.util.DBConnection;
import com.project.client_magnet.util.DBSetting;

public class LogsDao implements IDao<Logs> {
	Connection connection = null;
	private List<Logs> Log = new ArrayList<>();

	public LogsDao() {
		super();
	}

//	public LogsDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}


	
	public boolean addfromSchedule(int repID,int empID,String interactionType,Date date,String interactionSummary ) {
		boolean result = false;
		try {
			connection = new DBSetting().getConnection();
			String sqlQuery = "insert into  Logs(RepID,EmpID,InteractionType,Dates,Notes) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, repID);
			preparedStatement.setInt(2,empID);
			preparedStatement.setString(3,interactionType);
			preparedStatement.setDate(4, date);
			preparedStatement.setString(5,interactionSummary);
			if (preparedStatement.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	public Logs create(Logs Logs) {
		try {
			connection = new DBSetting().getConnection();
			String sqlQuery = "insert into  Logs(RepID,EmpID,InteractionType,Date,Notes) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, Logs.getRepresentative().getRepID());
			preparedStatement.setInt(2, Logs.getEmployee().getEmpID());
			preparedStatement.setString(3, Logs.getInteractionType());
			preparedStatement.setDate(4, Logs.getDates());
			preparedStatement.setString(5, Logs.getNotes());
			if (preparedStatement.executeUpdate() < 0) {
				Logs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Logs;
	}

	@Override
	public boolean update(int id, Logs t) {
		boolean result = false;
		try {
			connection = new DBSetting().getConnection();
			String sqlQuery = "update Logs set InteractionType=?, Date=?, Notes=? where RepID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, t.getInteractionType());
			preparedStatement.setDate(4, t.getDates());
			preparedStatement.setString(3, t.getNotes());
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
	public boolean delete(int id) {
		boolean result = false;
		try {
			connection = new DBSetting().getConnection();
			String sqlQuery = "delete from Logs where RepID=?";
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
	public Logs findOne(int id) throws Exception {
		try {
			connection = new DBSetting().getConnection();
			final String sqlQuery = "Select RepID,EmpID,InteractionType,Date,Notes from Logs where RepID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Logs Logs = null;
			if (resultSet.next()) {
				int employeeId = resultSet.getInt(2);
				EmployeeDao employeeDao = new EmployeeDao();
				Employee employee;

				employee = employeeDao.findOne(employeeId);
				int representativeId = resultSet.getInt(2);
				RepresentativeDao representativeDao = new RepresentativeDao();
				Representative representative = representativeDao.findOne(representativeId);

				Logs = new Logs(representative, employee, resultSet.getString(3), resultSet.getDate(4),
						resultSet.getString(5));
			}

			return Logs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Logs> findAll() throws Exception {

		try {
			connection = new DBSetting().getConnection();
			Statement selectStatement = connection.createStatement();

			final String sqlQuery = "select * from Logs";
			ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int employeeId = resultSet.getInt(2);
				EmployeeDao employeeDao = new EmployeeDao();
				Employee employee = employeeDao.findOne(employeeId);
				int representativeId = resultSet.getInt(1);
				RepresentativeDao representativeDao = new RepresentativeDao();
				Representative representative = representativeDao.findOne(representativeId);

				Logs Logs = new Logs(representative, employee, resultSet.getString(3), resultSet.getDate(4),
						resultSet.getString(5));
				System.out.println(Logs);
				Log.add(Logs);

			}
			if (Log.isEmpty())
				return null;
			return Log;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}