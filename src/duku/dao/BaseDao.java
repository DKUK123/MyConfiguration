package duku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	public Connection getConnection() {
		try {
			Class.forName("com.jdbc.mysql.Driver");
			Connection con = DriverManager.getConnection("jdb:mysql://localhost:3306/qn131person", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closePreparedStatement(PreparedStatement pst) {
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
}
