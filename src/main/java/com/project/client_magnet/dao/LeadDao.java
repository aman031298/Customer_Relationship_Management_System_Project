//package com.project.client_magnet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.project.client_magnet.model.Company;
//import com.project.client_magnet.model.Customer;
//import com.project.client_magnet.model.Lead;
//import com.project.client_magnet.model.Product;
//import com.project.client_magnet.model.Representative;
//import com.project.client_magnet.util.DBConnection;
//
//
//public class LeadDao implements IDao<Lead> {
//    private DBConnection dbConnection;
//
//    public LeadDao(DBConnection dbConnection) {
//        this.dbConnection = dbConnection;
//    }
//
//    public Lead findOne(int id) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        Lead lead = null;
//        try {
//            connection = dbConnection.getConnection();
//            String sqlQuery = "SELECT * FROM Lead WHERE leadID=?";
//            preparedStatement = connection.prepareStatement(sqlQuery);
//            preparedStatement.setInt(1, id);
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//            	 Company company=null;
//                 Product product=null;
//                 Representative rep=null;
//                 
//                 CompanyDao cdao=new CompanyDao(dbConnection);
//                 int cid=resultSet.getInt(2);
//                 company=cdao.findOne(cid);
//                 
//                 ProductDao pdao=new ProductDao(dbConnection);
//                 int pid=resultSet.getInt(3);
//                 product=pdao.findOne(pid);
//                 
//                 
//                 RepresentativeDao rdao=new RepresentativeDao(dbConnection);
//                 int rid=resultSet.getInt(8);
//                 rep=rdao.findOne(rid);
//                 
////                Representative representative = new Representative(resultSet.getInt("repId"), resultSet.getString("repName"), sqlQuery, sqlQuery, sqlQuery, company);
//                lead = new Lead(resultSet.getInt("leadID"),
//                                company,
//                                product,
//                                resultSet.getString("industryType"),
//                                resultSet.getString("source"),
//                                resultSet.getInt("interestLevel"),
//                                resultSet.getDouble("dealSize"),
//                                rep);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lead;
//    }
//
//    public List<Lead> findAll() {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<Lead> leads = new ArrayList<>();
//        try {
//            connection = dbConnection.getConnection();
//            String sqlQuery = "SELECT * FROM Lead";
//            preparedStatement = connection.prepareStatement(sqlQuery);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) 
//            {
//                Company company=null;
//                Product product=null;
//                Representative rep=null;
//                
//                CompanyDao cdao=new CompanyDao(dbConnection);
//                int cid=resultSet.getInt(2);
//                company=cdao.findOne(cid);
//                
//                ProductDao pdao=new ProductDao(dbConnection);
//                int pid=resultSet.getInt(3);
//                product=pdao.findOne(pid);
//                
//                
//                RepresentativeDao rdao=new RepresentativeDao(dbConnection);
//                int rid=resultSet.getInt(8);
//                rep=rdao.findOne(rid);
//                
//                
//                
//                
//                Lead lead = new Lead(resultSet.getInt("leadID"),
//                                    company,
//                                    product,
//                                    resultSet.getString("industryType"),
//                                    resultSet.getString("source"),
//                                    resultSet.getInt("interestLevel"),
//                                    resultSet.getDouble("dealSize"),
//                                    rep);
//                System.out.println(lead);
//                leads.add(lead);
//                
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
//        return leads;
//    }
//
//   
//
//    @Override
//    public Lead create(Lead Lead) {	
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="insert into Lead(cid,productid,industrytype,source,interestlevel,dealsize,repid) values(?,?,?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, Lead.getCompany().getCid());
//			preparedStatement.setInt(2, Lead.getProduct().getProductID());
//			preparedStatement.setString(3, Lead.getIndustryType());
//			preparedStatement.setString(4, Lead.getSource());	
//			preparedStatement.setInt(5, Lead.getInterestLevel());	
//			preparedStatement.setDouble(6, Lead.getDealSize());
//			preparedStatement.setInt(7, Lead.getRepresentative().getRepID());
//			if(preparedStatement.executeUpdate()<0) {
//				Lead=null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return Lead;
//	}
//
//    @Override
//    public boolean update(int id, Lead lead) throws Exception {
//		boolean result=false;
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="update  Lead set interestlevel = ? where cid=?";
//			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, lead.getInterestLevel());
//			preparedStatement.setInt(2, id);
//			if(preparedStatement.executeUpdate()>0) {
//				result=true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//    }
//
//    @Override
//    public boolean delete(int id) throws Exception {
//
//		boolean result=false;
//		try {
//			Connection connection=dbConnection.getConnection();
//			String sqlQuery="delete from Lead where leadid=?";
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
//    }
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
import com.project.client_magnet.model.Customer;
import com.project.client_magnet.model.Lead;
import com.project.client_magnet.model.Product;
import com.project.client_magnet.model.Representative;
import com.project.client_magnet.util.DBSetting;

public class LeadDao implements IDao<Lead> {
	Connection connection = null;

//    public LeadDao(DBConnection dbConnection) {
//        this.dbConnection = dbConnection;
//    }
	
	public boolean addToLeadCompanyRep(String companyName,String companyEmail,String companyAddress,String industryType,String source,int interestLevel,int dealSize,int productId,String product,String repName,String repEmail,String repMobile,String jobRole) {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			
			String sql_check_company = "select email from company where email = ?";
			PreparedStatement pscompany = connection.prepareStatement(sql_check_company);
			pscompany.setString(1, companyEmail);
			ResultSet rscompanycheck = pscompany.executeQuery();
			if (!rscompanycheck.next()) {
				
			
			String sqlQuery = "insert into Company(CNAME,ADDRESS,EMAIL)values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, companyName);
			preparedStatement.setString(2, companyAddress);
			preparedStatement.setString(3, companyEmail);
			
			if (preparedStatement.executeUpdate() > 0) {
				
				String sqlselectcompany = "select CID from company where EMAIL = ? ";
				
				PreparedStatement prepared_statement = connection.prepareStatement(sqlselectcompany);
				prepared_statement.setString(1, companyEmail);
				ResultSet rs = prepared_statement.executeQuery();
				if (rs.next()) {
					int cid = rs.getInt("CID");
				
				
				String sql = "insert into representative(REPNAME,CID,REPEMAIL,REPMOBILE,JOBROLE)values(?,?,?,?,?)";
				PreparedStatement prepared_Statement = connection.prepareStatement(sql);
				prepared_Statement.setString(1, repName);
				prepared_Statement.setInt(2, cid);
				prepared_Statement.setString(3, repEmail);
				prepared_Statement.setString(4, repMobile);
				prepared_Statement.setString(5, jobRole);
				
				if(prepared_Statement.executeUpdate() > 0) {
					
					String sqlselectrep = "select REPID from representative where REPEMAIL = ? ";
					
					PreparedStatement ps = connection.prepareStatement(sqlselectrep);
					ps.setString(1, repEmail);
					ResultSet rsrep = ps.executeQuery();
					if(rsrep.next()) {
					int repid = rsrep.getInt(1);
					System.out.println(repid);
					System.out.println(productId);
					String sqlleads = "insert into lead(CID,PRODUCTID,INDUSTRYTYPE,SOURCE,INTERESTLEVEL,DEALSIZE,REPID)values(?,?,?,?,?,?,?)";
					PreparedStatement prepared_Statement_lead = connection.prepareStatement(sqlleads);
					prepared_Statement_lead.setInt(1, cid);
					prepared_Statement_lead.setInt(2, productId);
					prepared_Statement_lead.setString(3, industryType);
					prepared_Statement_lead.setString(4, source);
					prepared_Statement_lead.setInt(5, interestLevel);
					prepared_Statement_lead.setInt(6, dealSize);
					prepared_Statement_lead.setInt(7, repid);
					System.out.println(productId);
					if(prepared_Statement_lead.executeUpdate()>0) {
						result = true;
					}
					else {
						System.out.println("not lead entered");
					}
					
				}}
				else {
					System.out.println("not representative entered");
				}}
				
				
				
			}
			else {
				System.out.println("not company entered");
			}
		}
		
			else {
				
				String sqlselectcompany = "select CID from company where EMAIL = ? ";
				
				PreparedStatement prepared_statement = connection.prepareStatement(sqlselectcompany);
				prepared_statement.setString(1, companyEmail);
				ResultSet rs = prepared_statement.executeQuery();
				if (rs.next()) {
					int cid = rs.getInt("CID");
				
				
				String sql = "insert into representative(REPNAME,CID,REPEMAIL,REPMOBILE,JOBROLE)values(?,?,?,?,?)";
				PreparedStatement prepared_Statement = connection.prepareStatement(sql);
				prepared_Statement.setString(1, repName);
				prepared_Statement.setInt(2, cid);
				prepared_Statement.setString(3, repEmail);
				prepared_Statement.setString(4, repMobile);
				prepared_Statement.setString(5, jobRole);
				
				if(prepared_Statement.executeUpdate() > 0) {
					
					String sqlselectrep = "select REPID from representative where REPEMAIL = ? ";
					
					PreparedStatement ps = connection.prepareStatement(sqlselectrep);
					ps.setString(1, repEmail);
					ResultSet rsrep = ps.executeQuery();
					if(rsrep.next()) {
					int repid = rsrep.getInt(1);
					System.out.println(repid);
					System.out.println(productId);
					String sqlleads = "insert into lead(CID,PRODUCTID,INDUSTRYTYPE,SOURCE,INTERESTLEVEL,DEALSIZE,REPID)values(?,?,?,?,?,?,?)";
					PreparedStatement prepared_Statement_lead = connection.prepareStatement(sqlleads);
					prepared_Statement_lead.setInt(1, cid);
					prepared_Statement_lead.setInt(2, productId);
					prepared_Statement_lead.setString(3, industryType);
					prepared_Statement_lead.setString(4, source);
					prepared_Statement_lead.setInt(5, interestLevel);
					prepared_Statement_lead.setInt(6, dealSize);
					prepared_Statement_lead.setInt(7, repid);
					System.out.println(productId);
					if(prepared_Statement_lead.executeUpdate()>0) {
						result = true;
					}
					else {
						System.out.println("not lead entered");
					}
					
				}}
				else {
					System.out.println("not representative entered");
				}}
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public Lead findOne(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Lead lead = null;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "SELECT * FROM Lead WHERE leadID=?";
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Company company = null;
				Product product = null;
				Representative rep = null;

				CompanyDao cdao = new CompanyDao();
				int cid = resultSet.getInt(2);
				company = cdao.findOne(cid);

				ProductDao pdao = new ProductDao();
				int pid = resultSet.getInt(3);
				product = pdao.findOne(pid);

				RepresentativeDao rdao = new RepresentativeDao();
				int rid = resultSet.getInt(8);
				rep = rdao.findOne(rid);

//                Representative representative = new Representative(resultSet.getInt("repId"), resultSet.getString("repName"), sqlQuery, sqlQuery, sqlQuery, company);
				lead = new Lead(resultSet.getInt("leadID"), company, product, resultSet.getString("industryType"),
						resultSet.getString("source"), resultSet.getInt("interestLevel"),
						resultSet.getDouble("dealSize"), rep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lead;
	}

	public List<Lead> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Lead> leads = new ArrayList<>();
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "SELECT * FROM Lead";
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Company company = null;
				Product product = null;
				Representative rep = null;

				CompanyDao cdao = new CompanyDao();
				int cid = resultSet.getInt(2);
				company = cdao.findOne(cid);

				ProductDao pdao = new ProductDao();
				int pid = resultSet.getInt(3);
				product = pdao.findOne(pid);

				RepresentativeDao rdao = new RepresentativeDao();
				int rid = resultSet.getInt(8);
				rep = rdao.findOne(rid);

				Lead lead = new Lead(resultSet.getInt("leadID"), company, product, resultSet.getString("industryType"),
						resultSet.getString("source"), resultSet.getInt("interestLevel"),
						resultSet.getDouble("dealSize"), rep);
				System.out.println(lead);
				leads.add(lead);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leads;
	}

	
	
	@Override
	public Lead create(Lead Lead) {
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "insert into Lead(cid,productid,industrytype,source,interestlevel,dealsize,repid) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, Lead.getCompany().getCid());
			preparedStatement.setInt(2, Lead.getProduct().getProductID());
			preparedStatement.setString(3, Lead.getIndustryType());
			preparedStatement.setString(4, Lead.getSource());
			preparedStatement.setInt(5, Lead.getInterestLevel());
			preparedStatement.setDouble(6, Lead.getDealSize());
			preparedStatement.setInt(7, Lead.getRepresentative().getRepID());
			if (preparedStatement.executeUpdate() < 0) {
				Lead = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Lead;
	}

	@Override
	public boolean update(int id, Lead lead) throws Exception {
		boolean result = false;
		try {
			connection = DBSetting.getConnection();
			String sqlQuery = "update  Lead set interestlevel = ? where cid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, lead.getInterestLevel());
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
			String sqlQuery = "delete from Lead where leadid=?";
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
	
//	@Override
//	public boolean delete(int id) throws Exception {
//
//		boolean result = false;
//		try {
//			connection = DBSetting.getConnection();
//			String sqlQuery = "delete from Lead where leadid=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//			preparedStatement.setInt(1, id);
//			if (preparedStatement.executeUpdate() > 0) {
//				try {
//				Statement stmt = connection.createStatement();
//				String sqldltrep = "delete from representative where repid not in(select repid from lead)";
//				stmt.executeUpdate(sqldltrep);
//				}
//				catch (SQLException e){
//					e.printStackTrace();
//				}
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
	public void updateILinLead(int interestLevel, int repID, int empID) throws Exception {

	    try {
	        connection = DBSetting.getConnection();
	        if (interestLevel == 10) {
	        	System.out.println("interest level 10");
	            String sql_select = "select * from lead where repId = ? and productid=(select productid from team where teamid =(select teamid from employee where empid=?))";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql_select);
	            preparedStatement.setInt(1, repID);
	            preparedStatement.setInt(2, empID);
	            ResultSet rs_lead = preparedStatement.executeQuery();
	            System.out.println("Hiiiiiiiiiii");
	            if (rs_lead.next()) { // Check if there are any results
	                int lead_id = rs_lead.getInt("LEADID");
	                int company_id = rs_lead.getInt("CID");
	                int product_id = rs_lead.getInt("PRODUCTID");
	                String industry_type = rs_lead.getString("INDUSTRYTYPE");
	                int deal_size = rs_lead.getInt("DEALSIZE");

	                String sql_select_company = "select * from company where cid = ?";
	                PreparedStatement prepared_statement_company = connection.prepareStatement(sql_select_company);
	                prepared_statement_company.setInt(1, company_id);

	                System.out.println("Hwllllllllllloo");
	                
	                ResultSet rs_company = prepared_statement_company.executeQuery();
	                if (rs_company.next()) { // Check if there are any results
	                    String company_name = rs_company.getString("CNAME");
	                    String address = rs_company.getString("ADDRESS");
	                    String email = rs_company.getString("EMAIL");

	                    String sql_insert_customer = "insert into customer(cust_name, productid, industrytype, address, email) values(?,?,?,?,?)";
	                    PreparedStatement prepared_statement_cust = connection.prepareStatement(sql_insert_customer);
	                    prepared_statement_cust.setString(1, company_name);
	                    prepared_statement_cust.setInt(2, product_id);
	                    prepared_statement_cust.setString(3, industry_type);
	                    prepared_statement_cust.setString(4, address);
	                    prepared_statement_cust.setString(5, email);
//	                    prepared_statement_cust.setInt(6, repID); // Assuming repID is needed in customer table
//	                    prepared_statement_cust.setInt(7, deal_size); // Assuming deal_size is needed in customer table
	                    prepared_statement_cust.executeUpdate();
	                    
	                    System.out.println("Namasteeee");
	                }
	                rs_company.close(); // Close ResultSet
	            }
	            rs_lead.close(); // Close ResultSet
	        } else {
	            String sqlQuery = "update Lead set interestlevel = ? where repId = ? and productid=(select productid from team where teamid =(select teamid from employee where empid=?))";
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	            preparedStatement.setInt(1, interestLevel);
	            preparedStatement.setInt(2, repID);
	            preparedStatement.setInt(3, empID);
	            preparedStatement.executeUpdate();
	            
	            System.out.println("Namasteeee");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}

	

}