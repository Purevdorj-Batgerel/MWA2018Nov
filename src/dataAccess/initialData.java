package dataAccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class initialData {

    public static void createTables(Connection conn) {
        try {

            Statement stmt = conn.createStatement(); // Conn.createStatement();

            stmt.execute("CREATE TABLE staffs ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					FNAME VARCHAR(24) NOT NULL," + "					LNAME VARCHAR(24) NOT NULL,"
                    + "					USERNAME VARCHAR(24) NOT NULL,"
                    + "					PASSWORD VARCHAR(100) NOT NULL," + "					DOB DATE,"
                    + "					TYPE VARCHAR(24),"
                    + "				    CONSTRAINT Staff_primary_key PRIMARY KEY (id))");

            stmt.execute("CREATE TABLE movies ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					name VARCHAR(40) NOT NULL," + "					type VARCHAR(24),"
                    + "					duringTime INTEGER," + "					rate VARCHAR(24),"
                    + "					director VARCHAR(100)," + "					picture VARCHAR(255),"
                    + "					description  VARCHAR(1000),"
                    + "				    CONSTRAINT movie_primary_key PRIMARY KEY (id))");

            stmt.execute("CREATE TABLE halls ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					hallNo INTEGER NOT NULL," + "					NAME VARCHAR(24),"
                    + "					totalSeat INTEGER ,"
                    + "				    CONSTRAINT hall_primary_key PRIMARY KEY (id))");

            stmt.execute("CREATE TABLE schedules ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					sdate DATE," + "					movid INTEGER,"
                    + "					hallid INTEGER ,"
                    + "				    CONSTRAINT schedule_primary_key PRIMARY KEY (id))");

            stmt.execute("CREATE TABLE bookings ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					bdate DATE," + "					mid INTEGER NOT NULL,"
                    + "					schid INTEGER NOT NULL," + "					payid INTEGER NOT NULL,"
                    + "					qty INTEGER ,"
                    + "				    CONSTRAINT booking_primary_key PRIMARY KEY (id))");

            stmt.execute("CREATE TABLE payments ("
                    + "					id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "					pdate DATE," + "					mid INTEGER NOT NULL,"
                    + "					amount INTEGER,"
                    + "				    CONSTRAINT payment_primary_key PRIMARY KEY (id))");

            // insert initial data
            // staffs
            stmt.execute(
                    "INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB, TYPE ) VALUES ('Bob', 'John', 'bob', '123', '1996-09-12', 'STAFF')");
            stmt.execute(
                    "INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB, TYPE ) VALUES ('Bold', 'Bat', 'bold', '1', '1996-09-07', 'STAFF')");
            // members
            stmt.execute(
                    "INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB, TYPE ) VALUES ('Denis', 'John', 'admin', '123', '1986-01-09', 'MEMBER')");
            stmt.execute(
                    "INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB, TYPE ) VALUES ('nice', 'Guru', 'nice', '123', '1999-09-11', 'MEMBER')");
            stmt.execute(
                    "INSERT INTO STAFFS(FNAME, LNAME, USERNAME, PASSWORD, DOB, TYPE ) VALUES ('Bill', 'Yoga', 'bill', '123', '1997-07-10', 'MEMBER')");

            // halls
            stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (1, 'Laser', 250)");
            stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (2, 'IMAX', 350)");
            stmt.execute("INSERT INTO HALLS(hallNo, NAME, totalSeat) VALUES (3, 'Dolby', 200)");

            // movies

            stmt.execute(
                    "INSERT INTO MOVIES(name, type, duringTime, rate, director, description, picture) VALUES ('Avengers - Infinity War', 'ACTION', 156, 'PG_13', 'DIRECTOR', '', '/Main/Views/HO00000490.jpg')");
            stmt.execute(
                    "INSERT INTO MOVIES(name, type, duringTime, rate, director, description, picture) VALUES ('Hotel Transylvania 3', 'ANIMATION', 97, 'PG_13', 'DIRECTOR', '', '/Main/Views/HO00000502.jpg')");
            stmt.execute(
                    "INSERT INTO MOVIES(name, type, duringTime, rate, director, description, picture) VALUES ('Mission Impossible: FALLOUT', 'ACTION', 147, 'PG_13', 'DIRECTOR', '','/Main/Views/HO00000504.jpg')");
            stmt.execute(
                    "INSERT INTO MOVIES(name, type, duringTime, rate, director, description, picture) VALUES ('The MEG', 'ACTION', 113, 'PG_13', 'DIRECTOR', '','/Main/Views/HO00000506.jpg')");
            stmt.execute(
                    "INSERT INTO MOVIES(name, type, duringTime, rate, director, description, picture) VALUES ('Christoper Robin', 'ANIMATION', 105, 'PG_13', 'DIRECTOR', '','/Main/Views/HO00000507.jpg')");

            System.out.println("created tables");

            stmt.close();

        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Talbe already exists.");
            }
        }

    }

}
