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
//import com.project.client_magnet.model.Team;
//import com.project.client_magnet.util.DBConnection;
//
//public class CompanyDao implements IDao<Company> {
//	
//	private DBConnection dbConnection;
//	private List<Company> Companies = new ArrayList<>();
//	
//	public CompanyDao() {
//		super();
//	}
//
//	public CompanyDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	@Override
//	public Company create(Company Company) {
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="insert into Company(cname,address,email) values(?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, Company.getCname());
//			preparedStatement.setString(2, Company.getAddress());
//			preparedStatement.setString(3, Company.getEmail());	
//				
//			if(preparedStatement.executeUpdate()<0) {
//				Company=null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return Company;
//	}
//	
//	@Override
//	public Company findOne(int id) throws SQLException {
//		Connection connection=dbConnection.getConnection();
//		final String sqlQuery="select * from company where cid = ?";
//		PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery); 
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet=preparedStatement.executeQuery();
//		Company Company=null;
//		if(resultSet.next()) {
//			 Company= new Company(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));			
//		}
//		
//		return Company;
//	}
//
//	@Override
//	public List<Company> findAll() throws SQLException {
//
//		Connection connection = dbConnection.getConnection();
//		Statement selectStatement = connection.createStatement();
//
//		final String sqlQuery = "select * from Company";
//		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//		while (resultSet.next()) {
//
//			Company Company = new Company(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
//			System.out.println(Company);
//			Companies.add(Company);
//
//		}
//		if (Companies.isEmpty())
//			return null;
//		return Companies;
//	}
//
//
//
//	@Override
//	public boolean update(int id, Company t) throws Exception {
//		boolean result=false;
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="update Company set cname=?, address=? where cid=?";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, t.getCname());
//			preparedStatement.setString(2, t.getAddress());
//			preparedStatement.setInt(3, id);
//			if(preparedStatement.executeUpdate()>0) {
//				result=true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
//
//	@Override
//	public boolean delete(int id) throws Exception {
//		boolean result = false;
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = dbConnection.getConnection();
//            String sqlQuery = "DELETE FROM Company WHERE cid=?";
//            preparedStatement = connection.prepareStatement(sqlQuery);
//            preparedStatement.setInt(1, id);
//
//            int rowsDeleted = preparedStatement.executeUpdate();
//            if (rowsDeleted > 0) {
//                result = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
//        return result;
//	}
//	
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
import com.project.client_magnet.model.Team;
import com.project.client_magnet.util.DBSetting;

public class CompanyDao implements IDao<Company> {
	
	Connection connection = null;
	private List<Company> Companies = new ArrayList<>();
	
	public CompanyDao() {
		super();
	}

//	public CompanyDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}

	@Override
	public Company create(Company Company) {
		try {
			connection=DBSetting.getConnection();
			String sqlQuery="insert into Company(cname,address,email) values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, Company.getCname());
			preparedStatement.setString(2, Company.getAddress());
			preparedStatement.setString(3, Company.getEmail());	
				
			if(preparedStatement.executeUpdate()<0) {
				Company=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Company;
	}
	
	@Override
	public Company findOne(int id) throws SQLException {
		connection=DBSetting.getConnection();
		final String sqlQuery="select * from company where cid = ?";
		PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery); 
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		Company Company=null;
		if(resultSet.next()) {
			 Company= new Company(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));			
		}
		
		return Company;
	}

	@Override
	public List<Company> findAll() throws SQLException {

		connection = DBSetting.getConnection();
		Statement selectStatement = connection.createStatement();

		final String sqlQuery = "select * from Company";
		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

		while (resultSet.next()) {

			Company Company = new Company(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
			System.out.println(Company);
			Companies.add(Company);

		}
		if (Companies.isEmpty())
			return null;
		return Companies;
	}



	@Override
	public boolean update(int id, Company t) throws Exception {
		boolean result=false;
		try {
			connection=DBSetting.getConnection();
			String sqlQuery="update Company set cname=?, address=? where cid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, t.getCname());
			preparedStatement.setString(2, t.getAddress());
			preparedStatement.setInt(3, id);
			if(preparedStatement.executeUpdate()>0) {
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBSetting.getConnection();
            String sqlQuery = "DELETE FROM Company WHERE cid=?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return result;
	}
	

}