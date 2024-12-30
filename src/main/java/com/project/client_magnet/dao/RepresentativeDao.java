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
//import com.project.client_magnet.model.Company;
//import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.util.DBConnection;
//
//public class RepresentativeDao implements IDao<Representative> {
//	private DBConnection dbConnection;
//	private List<Representative> Representatives = new ArrayList<>();
//
//	public RepresentativeDao() {
//		super();
//	}
//
//	public RepresentativeDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	@Override
//	public Representative create(Representative Representative) {
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "insert into  Representative(RepID,RepName,CID,RepEmail,RepMobile,JobRole) values(?,?,?,?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, Representative.getRepID());
//			preparedStatement.setString(2, Representative.getRepName());
//			preparedStatement.setInt(3, Representative.getCompany().getCid());
//			preparedStatement.setString(4, Representative.getRepMobile());
//			preparedStatement.setString(5, Representative.getJobRole());
//			if (preparedStatement.executeUpdate() < 0) {
//				Representative = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return Representative;
//	}
//
//	@Override
//	public boolean update(int id, Representative t) {
//		boolean result = false;
//		try {
//			Connection connection = dbConnection.getConnection();
//			String sqlQuery = "update  Representative set RepName=?, RepEmail=?, RepMobile=? where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, t.getRepName());
//			preparedStatement.setString(2, t.getRepEmail());
//			preparedStatement.setString(3, t.getRepMobile());
//			preparedStatement.setInt(4, id);
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
//			String sqlQuery = "delete from Customer where cust_id=?";
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
//	public Representative findOne(int id) throws SQLException {
//		Connection connection = dbConnection.getConnection();
//		final String sqlQuery = "Select RepID,RepName,CID,RepEmail,RepMobile,JobRole from representative where RepID=?";
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		Representative Representative = null;
//		if (resultSet.next()) {
//			int companyId = resultSet.getInt(3);
//			CompanyDao companyDao = new CompanyDao(dbConnection);
//			Company company = companyDao.findOne(companyId);
//
//			Representative = new Representative(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
//					resultSet.getString(4), resultSet.getString(5), company);
//		}
//
//		return Representative;
//	}
//
//	@Override
//	public List<Representative> findAll() throws SQLException {
//
//		Connection connection = dbConnection.getConnection();
//		Statement selectStatement = connection.createStatement();
//
//		final String sqlQuery = "select * from Representative";
//		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//		while (resultSet.next()) {
//			int companyId = resultSet.getInt(3);
//			CompanyDao companyDao = new CompanyDao(dbConnection);
//			Company company = companyDao.findOne(companyId);
//
//			Representative Representative = new Representative(resultSet.getInt(1), resultSet.getString(2),
//					resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), company);
//			System.out.println(Representative);
//			Representatives.add(Representative);
//
//		}
//		if (Representatives.isEmpty())
//			return null;
//		return Representatives;
//	}
//
//}

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
//import com.project.client_magnet.model.Company;
//import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.util.DBSetting;
//
//public class RepresentativeDao implements IDao<Representative> {
//	Connection connection = null;
//	private List<Representative> Representatives = new ArrayList<>();
//
//	public RepresentativeDao() {
//		super();
//	}

//	public RepresentativeDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}

//	@Override
//	public Representative create(Representative Representative) {
//		try {
//			connection = DBSetting.getConnection();
//			String sqlQuery = "insert into  Representative(RepID,RepName,CID,RepEmail,RepMobile,JobRole) values(?,?,?,?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, Representative.getRepID());
//			preparedStatement.setString(2, Representative.getRepName());
//			preparedStatement.setInt(3, Representative.getCompany().getCid());
//			preparedStatement.setString(4, Representative.getRepMobile());
//			preparedStatement.setString(5, Representative.getJobRole());
//			if (preparedStatement.executeUpdate() < 0) {
//				Representative = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return Representative;
//	}
//
//	@Override
//	public boolean update(int id, Representative t) {
//		boolean result = false;
//		try {
//			connection = DBSetting.getConnection();
//			String sqlQuery = "update  Representative set RepName=?, RepEmail=?, RepMobile=? where RepID=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, t.getRepName());
//			preparedStatement.setString(2, t.getRepEmail());
//			preparedStatement.setString(3, t.getRepMobile());
//			preparedStatement.setInt(4, id);
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
//			connection = DBSetting.getConnection();
//			String sqlQuery = "delete from Customer where cust_id=?";
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
//	public Representative findOne(int id) throws SQLException {
//		connection = DBSetting.getConnection();
//		final String sqlQuery = "Select RepID,RepName,CID,RepEmail,RepMobile,JobRole from representative where RepID=?";
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		Representative Representative = null;
//		if (resultSet.next()) {
//			int companyId = resultSet.getInt(3);
//			CompanyDao companyDao = new CompanyDao();
//			Company company = companyDao.findOne(companyId);
//
//			Representative = new Representative(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
//					resultSet.getString(4), resultSet.getString(5), company);
//		}
//
//		return Representative;
//	}
//
//	@Override
//	public List<Representative> findAll() throws SQLException {
//
//		connection = DBSetting.getConnection();
//		Statement selectStatement = connection.createStatement();
//
//		final String sqlQuery = "select * from Representative";
//		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//		while (resultSet.next()) {
//			int companyId = resultSet.getInt(3);
//			CompanyDao companyDao = new CompanyDao();
//			Company company = companyDao.findOne(companyId);
//
//			Representative Representative = new Representative(resultSet.getInt(1), resultSet.getString(2),
//					resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), company);
//			System.out.println(Representative);
//			Representatives.add(Representative);
//
//		}
//		if (Representatives.isEmpty())
//			return null;
//		return Representatives;
//	}
//
//}


package com.project.client_magnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.model.Company;
import com.project.client_magnet.model.Representative;
import com.project.client_magnet.util.DBSetting;

public class RepresentativeDao implements IDao<Representative> {
	Connection connection = null;
	private List<Representative> Representatives = new ArrayList<>();

	public RepresentativeDao() {
		super();
	}

//	public RepresentativeDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}

	@Override
	public Representative create(Representative Representative) {
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into  Representative(RepName,CID,RepEmail,RepMobile,JobRole) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, Representative.getRepName());
			preparedStatement.setInt(2, Representative.getCompany().getCid());
			preparedStatement.setString(3, Representative.getRepEmail());
			preparedStatement.setString(4, Representative.getRepMobile());
			preparedStatement.setString(5, Representative.getJobRole());
			
			if (preparedStatement.executeUpdate() < 0) {
				Representative = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Representative;
	}

	@Override
	public boolean update(int id, Representative t) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "update  Representative set RepName=?, RepEmail=?, RepMobile=? where RepID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, t.getRepName());
			preparedStatement.setString(2, t.getRepEmail());
			preparedStatement.setString(3, t.getRepMobile());
			preparedStatement.setInt(4, id);
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
			String sqlQuery = "delete from Customer where cust_id=?";
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
	public Representative findOne(int id) throws SQLException {
		connection = DBSetting.getConnection();
		final String sqlQuery = "Select RepID,RepName,CID,RepEmail,RepMobile,JobRole from representative where RepID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Representative Representative = null;
		if (resultSet.next()) {
			int companyId = resultSet.getInt(3);
			CompanyDao companyDao = new CompanyDao();
			Company company = companyDao.findOne(companyId);

			Representative = new Representative(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), company);
		}

		return Representative;
	}

	@Override
	public List<Representative> findAll() throws SQLException {

		connection = DBSetting.getConnection();
		Statement selectStatement = connection.createStatement();

		final String sqlQuery = "select * from Representative";
		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

		while (resultSet.next()) {
			int companyId = resultSet.getInt(3);
			CompanyDao companyDao = new CompanyDao();
			Company company = companyDao.findOne(companyId);

			Representative Representative = new Representative(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), company);
			System.out.println(Representative);
			Representatives.add(Representative);

		}
		if (Representatives.isEmpty())
			return null;
		return Representatives;
	}

}