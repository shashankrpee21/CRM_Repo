package generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import generic.fileUtility.IPathConstants;

public class DataBaseUtility {

	Connection con;

	public void getDBconnection(String url, String username, String password) throws SQLException {

		try {
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
		}
	}

	public void getDBconnection() throws SQLException {

		try {
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUN, IPathConstants.dbPWD);
		} catch (Exception e) {
		}
	}

	public void closeDBConnection() throws SQLException {
		try {
			con.close();
		} catch (Exception e) {
			

		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet resultSet = null;
		try {
			Statement stat = con.createStatement();
			resultSet = stat.executeQuery(query);
		} catch (Exception e) {

		}
		return resultSet;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {

		}
		return result;
	}
}