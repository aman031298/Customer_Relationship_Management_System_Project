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
//import com.project.client_magnet.model.Customer;
//import com.project.client_magnet.model.Product;
//import com.project.client_magnet.util.DBConnection;
//
//public class CustomerDao implements IDao<Customer>{
//	private DBConnection dbConnection;
//	private List<Customer> Customers = new ArrayList<>();
//	
//	public CustomerDao() {
//		super();
//	}
//
//	public CustomerDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	@Override
//	public Customer create(Customer Customer) {	
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="insert into Customer(cust_name,productid,industrytype,address,email) values(?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, Customer.getCustName());
//			preparedStatement.setInt(2, Customer.getProduct().getProductID());
//			preparedStatement.setString(3, Customer.getIndustryType());
//			preparedStatement.setString(3, Customer.getAddress());	
//			preparedStatement.setString(3, Customer.getEmail());	
//			if(preparedStatement.executeUpdate()<0) {
//				Customer=null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return Customer;
//	}
//
//	@Override
//	public boolean update(int id, Customer t) {
//		boolean result=false;
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="update Customer set cust_name=?, address=? where cust_id=?";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setString(1, t.getCustName());
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
//	public boolean delete(int id) {
//		boolean result=false;
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="delete from Customer where cust_id=?";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, id);
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
//	public Customer findOne(int id) throws SQLException {
//		Connection connection=dbConnection.getConnection();
//		final String sqlQuery="select Cust_id,Cust_name,productid,industrytype,address,email from Customer where Cust_id=?";
//		PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery); 
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet=preparedStatement.executeQuery();
//		Customer Customer=null;
//		if(resultSet.next()) {
//			int productId = resultSet.getInt(3);
//            ProductDao productDao = new ProductDao(dbConnection);
//            Product product = productDao.findOne(productId);
//
//			Customer = new Customer(resultSet.getInt(1), resultSet.getString(2),product,resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));			
//		}
//		
//		return Customer;
//	}
//
//	@Override
//	public List<Customer> findAll() throws SQLException {
//	    List<Customer> customers = new ArrayList<>();
//
//	    try (Connection connection = dbConnection.getConnection();
//	         Statement selectStatement = connection.createStatement();
//	         ResultSet resultSet1 = selectStatement.executeQuery("SELECT * FROM Customer")) {
//
//	        while (resultSet1.next()) {
//	            int productId = resultSet1.getInt(3);
//	            ProductDao productDao = new ProductDao(dbConnection);
//	            Product product = productDao.findOne(productId);
//
//	            Customer customer = new Customer(resultSet1.getInt(1), resultSet1.getString(2), product,
//	                                              resultSet1.getString(4), resultSet1.getString(5),
//	                                              resultSet1.getString(6));
//	            System.out.println(customer);
//	            customers.add(customer);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        throw e; // Rethrow the exception to propagate it to the calling method
//	    }
//
//	    return customers;
//	}
//
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

import com.project.client_magnet.model.Customer;
import com.project.client_magnet.model.Product;
import com.project.client_magnet.util.DBSetting;

public class CustomerDao implements IDao<Customer> {
	Connection connection = null;
	private List<Customer> Customers = new ArrayList<>();

	public CustomerDao() {
		super();
	}

//	public CustomerDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}

	public boolean addLeadDirectToCustomer(String companyName,int productId,String industryType,String companyAddress,String companyEmail) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into Customer(cust_name,productid,industrytype,address,email) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1,companyName);
			preparedStatement.setInt(2, productId);
			preparedStatement.setString(3, industryType);
			preparedStatement.setString(4, companyAddress);
			preparedStatement.setString(5, companyEmail);
			if (preparedStatement.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	public Customer create(Customer Customer) {
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into Customer(cust_name,productid,industrytype,address,email) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, Customer.getCustName());
			preparedStatement.setInt(2, Customer.getProduct().getProductID());
			preparedStatement.setString(3, Customer.getIndustryType());
			preparedStatement.setString(3, Customer.getAddress());
			preparedStatement.setString(3, Customer.getEmail());
			if (preparedStatement.executeUpdate() < 0) {
				Customer = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Customer;
	}

	@Override
	public boolean update(int id, Customer t) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "update Customer set cust_name=?, address=? where cust_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, t.getCustName());
			preparedStatement.setString(2, t.getAddress());
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
	public Customer findOne(int id) throws SQLException {
		connection = DBSetting.getConnection();
		final String sqlQuery = "select Cust_id,Cust_name,productid,industrytype,address,email from Customer where Cust_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Customer Customer = null;
		if (resultSet.next()) {
			int productId = resultSet.getInt(3);
			ProductDao productDao = new ProductDao();
			Product product = productDao.findOne(productId);

			Customer = new Customer(resultSet.getInt(1), resultSet.getString(2), product, resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6));
		}

		return Customer;
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		List<Customer> customers = new ArrayList<>();

		try {
			connection = DBSetting.getConnection();
			Statement selectStatement = connection.createStatement();
			ResultSet resultSet1 = selectStatement.executeQuery("SELECT * FROM Customer");

			while (resultSet1.next()) {
				int productId = resultSet1.getInt(3);
				ProductDao productDao = new ProductDao();
				Product product = productDao.findOne(productId);

				Customer customer = new Customer(resultSet1.getInt(1), resultSet1.getString(2), product,
						resultSet1.getString(4), resultSet1.getString(5), resultSet1.getString(6));
				System.out.println(customer);
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Rethrow the exception to propagate it to the calling method
		}

		return customers;
	}

}