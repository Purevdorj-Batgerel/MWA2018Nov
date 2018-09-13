package dataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class initialData {


	/* private final static String encodeFileToBase64Binary(File file){
           String encodedfile = null;
           try {
               @SuppressWarnings("resource")
			FileInputStream fileInputStreamReader = new FileInputStream(file);
               byte[] bytes = new byte[(int)file.length()];
               fileInputStreamReader.read(bytes);
               encodedfile = Base64.getEncoder().encodeToString(bytes);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

           return encodedfile;
       }*/
	 
	public static void createTables(Connection conn) {
		try {
			
			Statement stmt = conn.createStatement(); //Conn.createStatement();
			
			stmt.execute("CREATE TABLE staffs ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					FNAME VARCHAR(24) NOT NULL," 
					+ "					LNAME VARCHAR(24) NOT NULL,"
					+ "					USERNAME VARCHAR(24) NOT NULL,"
					+ "					PASSWORD VARCHAR(100) NOT NULL," 
					+ "					DOB DATE,"
					+ "					TYPE VARCHAR(24),"
					+ "				    CONSTRAINT Staff_primary_key PRIMARY KEY (id))");
			

			stmt.execute("CREATE TABLE movies ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					name VARCHAR(40) NOT NULL," 
					+ "					type VARCHAR(24),"
					+ "					duringTime VARCHAR(24),"
					+ "					rate VARCHAR(24)," 
					+ "					director VARCHAR(100)," 
					+ "					picture BLOB," 
					+ "					description  VARCHAR(1000),"
					+ "				    CONSTRAINT movie_primary_key PRIMARY KEY (id))");

			stmt.execute("CREATE TABLE halls ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					hallNo INTEGER NOT NULL," 
					+ "					NAME VARCHAR(24),"
					+ "					totalSeat INTEGER ,"
					+ "				    CONSTRAINT hall_primary_key PRIMARY KEY (id))");

			stmt.execute("CREATE TABLE schedules ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					sdate DATE," 
					+ "					movid INTEGER,"
					+ "					hallid INTEGER ,"
					+ "				    CONSTRAINT schedule_primary_key PRIMARY KEY (id))");

			stmt.execute("CREATE TABLE bookings ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					bdate DATE," 
					+ "					mid INTEGER NOT NULL,"
					+ "					schid INTEGER NOT NULL," 
					+ "					payid INTEGER NOT NULL,"
					+ "				    CONSTRAINT booking_primary_key PRIMARY KEY (id))");
			
			stmt.execute("CREATE TABLE payments ("
					+ "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "					pdate DATE," 
					+ "					mid INTEGER NOT NULL,"
					+ "					amount INTEGER,"
					+ "				    CONSTRAINT payment_primary_key PRIMARY KEY (id))");

			stmt.execute("ALTER TABLE schedules ADD CONSTRAINT MOVIE_FK " + 
					"			Foreign Key (movid) REFERENCES movies (id)");
			stmt.execute("ALTER TABLE schedules ADD CONSTRAINT HALL_FK " + 
					"			Foreign Key (hallid) REFERENCES halls (id)");
			stmt.execute("ALTER TABLE bookings ADD CONSTRAINT SCHEDULE_FK " + 
					"			Foreign Key (schid) REFERENCES schedules (id)");
			stmt.execute("ALTER TABLE bookings ADD CONSTRAINT PAYMENT_FK " + 
					"			Foreign Key (payid) REFERENCES payments (id)");
			stmt.execute("ALTER TABLE bookings ADD CONSTRAINT MEMBER_FK " + 
					"			Foreign Key (mid) REFERENCES members (id)");
			
			
			// insert initial data
			//staffs
			stmt.execute("INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB ) VALUES ('Bob', 'John', 'bob', '123', '1996-09-12', 'STAFF')");
			stmt.execute("INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB ) VALUES ('Bold', 'Bat', 'bold', '1', '1996-09-07', 'STAFF')");
			//members
			stmt.execute("INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB ) VALUES ('Denis', 'John', 'admin', '123', '1986-01-09', 'MEMBER')");
			stmt.execute("INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB ) VALUES ('nice', 'Guru', 'nice', '123', '1999-09-11', 'MEMBER')");
			stmt.execute("INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB ) VALUES ('Bill', 'Yoga', 'bill', '123', '1997-07-10', 'MEMBER')");
			
			//halls
			stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (1, 'Laser', 250)");
			stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (2, 'IMAX', 350)");
			stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (3, 'Dolby', 200)");
			
			
			
			//System.out.println(System.getProperty("user.dir"));
			
		/*	String s = encodeFileToBase64Binary(new File(System.getProperty("user.dir")+"/src/Main/Views/HO00000490.jpg"));
			
			@SuppressWarnings("deprecation")
			InputStream ss = new StringBufferInputStream(s);
			System.out.println(ss);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES (?,?,?,?,?,?)");
			
			ps.setString(1, "Avengers - Infinity War");
			ps.setString(2, "ACTION");
			ps.setString(3, "120");
			ps.setString(4, "PG_13");
			ps.setString(5, "DIRECTOR");
			ps.setString(6, "");
			//ps.setAsciiStream(7, ss, s.length());
			ps.execute();
            conn.commit();*/
			
			//movies
			stmt.execute("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES ('Avengers - Infinity War', 'ACTION', 120, 'PG_13', 'DIRECTOR', '')");
			stmt.execute("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES ('Hotel Transylvania 3', 'ACTION', 120, 'PG_13', 'DIRECTOR', ''"); 
			stmt.execute("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES ('Mission Impossible: FALLOUT', 'ACTION', 120, 'PG_13', 'DIRECTOR', ''"); 
			stmt.execute("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES ('The MEG', 'ACTION', 120, 'PG_13', 'DIRECTOR', ''"); 
			stmt.execute("INSERT INTO MOVIES(name, type, duringTime, rate, director, description) VALUES ('Christoper Robin', 'ACTION', 120, 'PG_13', 'DIRECTOR', ''");
		
			System.out.println("created tables");
			
			stmt.close();

		} catch (SQLException e) {
		        if(e.getSQLState().equals("X0Y32")) {
		        	  System.out.println("Talbe already exists.");
		        }
		}
		

	}

}
