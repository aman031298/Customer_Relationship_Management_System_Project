//package com.project.client_magnet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.project.client_magnet.model.Product;
//import com.project.client_magnet.model.Team;
//import com.project.client_magnet.util.DBConnection;
//
//public class ProductDao implements IDao<Product> {
//    private DBConnection dbConnection;
//
//    public ProductDao(DBConnection dbConnection) {
//        this.dbConnection = dbConnection;
//    }
//
//    
//
//    public List<Product> findAll() throws SQLException {
//    	Connection connection = dbConnection.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<Product> products = new ArrayList<>();
//        try {
//            connection = dbConnection.getConnection();
//            String sqlQuery = "SELECT * FROM Product";
//            preparedStatement = connection.prepareStatement(sqlQuery);
//            
//            
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) 
//            {
//            	String query="Select * from team where teamId=?";
//            	PreparedStatement preparedStatement1 = connection.prepareStatement(query);
//            	int id=resultSet.getInt(3);
//            	preparedStatement1.setInt(1, id);
//            	 ResultSet result=preparedStatement1.executeQuery();
//            	 
//            	 Team team=null;
//            	
//            	 if(result.next())
//            	 {
//                team = new Team(result.getInt("teamId"), result.getString("teamName"));
//            	 }
//                Product product = new Product(resultSet.getInt("productID"),
//                                              resultSet.getString("productName"),
//                                              team);
//                System.out.println(product);
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
//        return products;
//    }
//
//	@Override
//	public Product create(Product t) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean update(int id, Product t) throws Exception {
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
//}


package com.project.client_magnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.model.Product;
import com.project.client_magnet.model.Team;
import com.project.client_magnet.util.DBSetting;

public class ProductDao implements IDao<Product> {
    Connection connection = null;

    
    public Product findOne(int id) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      Product product = null;
      try {
          connection = DBSetting.getConnection();
          String sqlQuery = "SELECT * FROM Product WHERE productID=?";
          preparedStatement = connection.prepareStatement(sqlQuery);
          preparedStatement.setInt(1, id);
          resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
          	String query="Select * from team where teamId=?";
          	PreparedStatement preparedStatement1 = connection.prepareStatement(query);
          	int tid=resultSet.getInt(3);
          	preparedStatement1.setInt(1, tid);
          	 ResultSet result=preparedStatement1.executeQuery();
          	 
          	 Team team=null;
          	
          	 if(result.next())
          	 {
              team = new Team(result.getInt("teamId"), result.getString("teamName"));
          	 }
              product = new Product(resultSet.getInt("productID"),
                                            resultSet.getString("productName"),
                                            team);
//              System.out.println(product);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } 
      return product;
  }
    public List<Product> findAll() throws SQLException {
    	connection = DBSetting.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DBSetting.getConnection();
            String sqlQuery = "SELECT * FROM Product";
            preparedStatement = connection.prepareStatement(sqlQuery);
            
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) 
            {
            	String query="Select * from team where teamId=?";
            	PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            	int id=resultSet.getInt(3);
            	preparedStatement1.setInt(1, id);
            	 ResultSet result=preparedStatement1.executeQuery();
            	 
            	 Team team=null;
            	
            	 if(result.next())
            	 {
                team = new Team(result.getInt("teamId"), result.getString("teamName"));
            	 }
                Product product = new Product(resultSet.getInt("productID"),
                                              resultSet.getString("productName"),
                                              team);
                System.out.println(product);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return products;
    }

	@Override
	public Product create(Product t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int id, Product t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}