package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Movie;

public class DBConnection {

	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:Cinema;create=true";

	public static Connection conn = null;
	private static Statement stmt = null;

	public DBConnection() throws SQLException {
		try {
			conn = DriverManager.getConnection(JDBC_URL);
			if (conn != null) {
				// initialdata();
				System.out.println("Connected");
			}

		} catch (SQLException e) {
			throw new SQLException("Cannot connect!!!");
		}
	}
	
	public Statement createStatement() {
		try {
			return stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getPassByUname(String uname) {
		String password = "";
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from staffs where username = '" + uname + "'");

			while (results.next()) {
				password = results.getString("password");
			}
			results.close();
			stmt.close();
			return password;

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return null;
	}
	
	public String addMovieByObject(Movie mov) {
		String password = "";
		try {
			stmt = conn.createStatement();
			
			ResultSet results = stmt.executeQuery("select * from movie");

			while (results.next()) {
				password = results.getString("password");
			}
			results.close();
			stmt.close();
			return password;

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return null;
	}

	public void selectStaffs() {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from staffs");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				if (rsmd.getColumnLabel(i) != "password")
					System.out.print(rsmd.getColumnLabel(i) + "\t\t");
			}

			System.out.println("\n-------------------------------------------------");

			while (results.next()) {
				int id = results.getInt(1);
				String lName = results.getString(2);
				String fName = results.getString(3);
				String uName = results.getString(4);
				String dob = results.getString(5);
				System.out.println(id + "\t\t" + lName + "\t\t" + fName + "\t\t" + uName + "\t\t" + dob);
			}
			results.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public void insertIntoTable(String fname, String lname, String dob, String uname, String pwd) {
		try {
			stmt = conn.createStatement();
			stmt.execute("insert into staffs(fname, lname, dob, username, password) values ('" + fname + "','" + lname
					+ "','" + dob + "','" + uname + "','" + pwd + "')");
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}


}
