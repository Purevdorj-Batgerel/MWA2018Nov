package dataAccess;

import java.sql.SQLException;
import java.sql.Statement;

public class initialData {
	
	public void initialdata() {
		try {
			DBConnection Conn = new DBConnection();
			Statement stmt = Conn.createStatement();
			stmt.execute("CREATE TABLE staffs ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					FNAME VARCHAR(24) NOT NULL," + "					LNAME VARCHAR(24) NOT NULL,"
					+ "					USERNAME VARCHAR(24) NOT NULL,"
					+ "					PASSWORD VARCHAR(100) NOT NULL," + "					DOB DATE,"
					+ "				    CONSTRAINT Staff_primary_key PRIMARY KEY (id))");
			/*
			 * + "CREATE TABLE members (\" +\r\n" +
			 * "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\" + \r\n"
			 * + "FNAME VARCHAR(24) NOT NULL, + \r\n" + "LNAME VARCHAR(24) NOT NULL, + \r\n"
			 * + "USERNAME VARCHAR(24), + \r\n" + "PASSWORD VARCHAR(100), + \r\n" +
			 * "DOB DATE, + \r\n" + " CONSTRAINT member_primary_key PRIMARY KEY (id))");
			 */

			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
