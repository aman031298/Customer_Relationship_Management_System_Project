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
//import com.project.client_magnet.dao.IDao;
//import com.project.client_magnet.model.Team;
//import com.project.client_magnet.util.DBConnection;
//
//public class TeamDao implements IDao<Team> {
//
//	private DBConnection dbConnection;
//	private List<Team> Teams = new ArrayList<>();
//
//	public TeamDao() {
//		super();
//	}
//
//	public TeamDao(DBConnection dbConnection) {
//		super();
//		this.dbConnection = dbConnection;
//	}
//
//	public Team findOne(int id) throws SQLException {
//		Connection connection = dbConnection.getConnection();
//		final String sqlQuery = "select * from team where teamid = ?";
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		Team Team = null;
//		if (resultSet.next()) {
//			Team = new Team(resultSet.getInt(1), resultSet.getString(2));
//		}
//
//		return Team;
//	}
//
//	@Override
//	public List<Team> findAll() throws SQLException {
//
//		Connection connection = dbConnection.getConnection();
//		Statement selectStatement = connection.createStatement();
//
//		final String sqlQuery = "select * from Team";
//		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
//
//		while (resultSet.next()) {
//
//			Team Team = new Team(resultSet.getInt(1), resultSet.getString(2));
//			System.out.println(Team);
//			Teams.add(Team);
//
//		}
//		if (Teams.isEmpty())
//			return null;
//		return Teams;
//	}
//
//	@Override
//	public Team create(Team t) throws Exception {
//
//		return null;
//	}
//
//	@Override
//	public boolean update(int id, Team t) throws Exception {
//
//		return false;
//	}
//
//	@Override
//	public boolean delete(int id) throws Exception {
//
//		return false;
//	}
//}


package com.project.client_magnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.client_magnet.dao.IDao;
import com.project.client_magnet.model.Team;
import com.project.client_magnet.util.DBSetting;

public class TeamDao implements IDao<Team> {

	Connection connection = null;
	private List<Team> Teams = new ArrayList<>();

	public TeamDao() {
		super();
	}

	

	public Team findOne(int id) throws SQLException {
		connection = DBSetting.getConnection();
		final String sqlQuery = "select * from team where teamid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Team Team = null;
		if (resultSet.next()) {
			Team = new Team(resultSet.getInt(1), resultSet.getString(2));
		}

		return Team;
	}

	@Override
	public List<Team> findAll() throws SQLException {

		connection = DBSetting.getConnection();
		Statement selectStatement = connection.createStatement();

		final String sqlQuery = "select * from Team";
		ResultSet resultSet = selectStatement.executeQuery(sqlQuery);

		while (resultSet.next()) {

			Team Team = new Team(resultSet.getInt(1), resultSet.getString(2));
			System.out.println(Team);
			Teams.add(Team);

		}
		if (Teams.isEmpty())
			return null;
		return Teams;
	}

	@Override
	public Team create(Team t) throws Exception {

		return null;
	}

	@Override
	public boolean update(int id, Team t) throws Exception {

		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {

		return false;
	}
}
