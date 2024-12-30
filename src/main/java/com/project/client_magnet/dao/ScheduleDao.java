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
//import com.project.client_magnet.model.Employee;
//import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.model.Schedule;
//import com.project.client_magnet.util.DBConnection;
//
//public class ScheduleDao implements IDao<Schedule> {
//	private DBConnection dbConnection;
//	private List<Schedule> Schedules = new ArrayList<>();
//
//	public ScheduleDao() {
//		super();
//	}
//
//	public ScheduleDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	@Override
//	public Schedule create(Schedule Schedule) {
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "insert into  Logs(RepID,EmpID,InteractionType,Date,PreferredTime) values(?,?,?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, Schedule.getRepresentative().getRepID());
//			preparedStatement.setInt(2, Schedule.getEmployee().getEmpID());
//			preparedStatement.setString(3, Schedule.getInteractionType());
//			preparedStatement.setDate(4, Schedule.getDates());
//			preparedStatement.setTimestamp(5, Schedule.getPreferredTime());
//			if (preparedStatement.executeUpdate() < 0) {
//				Schedule = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return Schedule;
//	}
//
//	@Override
//	public boolean update(int id, Schedule t) {
//		boolean result = false;
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "update Schedule set InteractionType=?, Date=?, PreferredTime=? where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(3, t.getInteractionType());
//			preparedStatement.setDate(4, t.getDates());
//			preparedStatement.setTimestamp(5, t.getPreferredTime());
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
//			String sqlQuery = "delete from Schedule where RepID=?";
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
//	public Schedule findOne(int id) throws Exception {
//		Connection connection = dbConnection.getConnection();
//		final String sqlQuery = "Select RepID,EmpID,InteractionType,Date,Notes from Schedule where RepID=?";
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		Schedule Schedule = null;
//		if (resultSet.next()) {
//			int employeeId = resultSet.getInt(2);
//			EmployeeDao employeeDao = new EmployeeDao(dbConnection);
//			Employee employee = employeeDao.findOne(employeeId);
//			int representativeId = resultSet.getInt(2);
//			RepresentativeDao representativeDao = new RepresentativeDao(dbConnection);
//			Representative representative = representativeDao.findOne(representativeId);
//
//			Schedule = new Schedule(representative, employee, resultSet.getString(3), resultSet.getDate(4),
//					resultSet.getTimestamp(5));
//		}
//
//		return Schedule;
//	}
//
//	@Override
//	public List<Schedule> findAll() throws Exception {
//
//		Connection connection = dbConnection.getConnection();
//		Statement selectStatement = connection.createStatement();
//
//		final String sqlQuery = "select * from Schedule";
//		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//		while (resultSet.next()) {
//			int employeeId = resultSet.getInt(2);
//			EmployeeDao employeeDao = new EmployeeDao(dbConnection);
//			Employee employee = employeeDao.findOne(employeeId);
//			int representativeId = resultSet.getInt(2);
//			RepresentativeDao representativeDao = new RepresentativeDao(dbConnection);
//			Representative representative = representativeDao.findOne(representativeId);
//
//			Schedule Schedule = new Schedule(representative, employee, resultSet.getString(3), resultSet.getDate(4),
//					resultSet.getTimestamp(5));
//			System.out.println(Schedule);
//			Schedules.add(Schedule);
//
//		}
//		if (Schedules.isEmpty())
//			return null;
//		return Schedules;
//	}
//}

package com.project.client_magnet.dao;

import java.sql.Timestamp;
//import java.security.Timestamp;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.model.Employee;
import com.project.client_magnet.model.Representative;
import com.project.client_magnet.model.Schedule;
import com.project.client_magnet.util.DBSetting;

public class ScheduleDao implements IDao<Schedule> {
	Connection connection = null;
	private List<Schedule> Schedules = new ArrayList<>();

	public ScheduleDao() {
		super();
	}

//	public ScheduleDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
	
	public boolean deleteOnScheduleCompleted(int repID,int empID,String interactionType) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "DELETE FROM Schedule WHERE repid=? AND empid=? AND INTERACTIONTYPE=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, repID);
			preparedStatement.setInt(2, empID);
			preparedStatement.setString(3, interactionType);
//			preparedStatement.setTimestamp(4, timestamp);

			if (preparedStatement.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean addScheduleDatabase(int repid, int empid, String interactiontype,java.sql.Timestamp preferedtime) {
		boolean flag = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into  Schedule(RepID,EmpID,InteractionType,PreferredTime) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, repid);
			preparedStatement.setInt(2, empid);
			preparedStatement.setString(3, interactiontype);
//			preparedStatement.setDate(4, Schedule.getDates());
			preparedStatement.setTimestamp(4, preferedtime);
			if (preparedStatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}


	@Override
	public Schedule create(Schedule Schedule) {
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into  Logs(RepID,EmpID,InteractionType,PreferredTime) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, Schedule.getRepresentative().getRepID());
			preparedStatement.setInt(2, Schedule.getEmployee().getEmpID());
			preparedStatement.setString(3, Schedule.getInteractionType());
//			preparedStatement.setDate(4, Schedule.getDates());
			preparedStatement.setTimestamp(4, Schedule.getPreferredTime());
			if (preparedStatement.executeUpdate() < 0) {
				Schedule = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Schedule;
	}

	@Override
	public boolean update(int id, Schedule t) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "update Schedule set InteractionType=?,  PreferredTime=? where RepID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, t.getInteractionType());
//			preparedStatement.setDate(4, t.getDates());
			preparedStatement.setTimestamp(2, t.getPreferredTime());
			preparedStatement.setInt(3, id);
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
			connection = DBSetting.getConnection();
			String sqlQuery = "delete from Schedule where RepID=?";
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
	public Schedule findOne(int id) throws Exception {
		connection = DBSetting.getConnection();
		final String sqlQuery = "Select RepID,EmpID,InteractionType,Notes from Schedule where RepID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Schedule Schedule = null;
		if (resultSet.next()) {
			int employeeId = resultSet.getInt(2);
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.findOne(employeeId);
			int representativeId = resultSet.getInt(2);
			RepresentativeDao representativeDao = new RepresentativeDao();
			Representative representative = representativeDao.findOne(representativeId);

			Schedule = new Schedule(representative, employee, resultSet.getString(3), 
					resultSet.getTimestamp(4));
		}

		return Schedule;
	}

	@Override
	public List<Schedule> findAll() throws Exception {

		connection = DBSetting.getConnection();
		Statement selectStatement = connection.createStatement();

		final String sqlQuery = "select * from Schedule";
		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			int employeeId = resultSet.getInt(2);
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.findOne(employeeId);
			int representativeId = resultSet.getInt(1);
			RepresentativeDao representativeDao = new RepresentativeDao();
			Representative representative = representativeDao.findOne(representativeId);

			Schedule Schedule = new Schedule(representative, employee, resultSet.getString(3),
					resultSet.getTimestamp(4));
			System.out.println(Schedule);
			Schedules.add(Schedule);

		}
		if (Schedules.isEmpty())
			return null;
		return Schedules;
	}
	
	public List<Schedule> findAllforEmployee(String email) throws Exception {

		connection = DBSetting.getConnection();
//		Statement selectStatement = connection.createStatement();

		final String sqlQuery = "select * from Schedule where empid = (select empid from employee where email = ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int employeeId = resultSet.getInt(2);
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.findOne(employeeId);
			int representativeId = resultSet.getInt(1);
			RepresentativeDao representativeDao = new RepresentativeDao();
			Representative representative = representativeDao.findOne(representativeId);

			Schedule Schedule = new Schedule(representative, employee, resultSet.getString(3),
					resultSet.getTimestamp(4));
			System.out.println(Schedule);
			Schedules.add(Schedule);

		}
		if (Schedules.isEmpty())
			return null;
		return Schedules;
	}
}