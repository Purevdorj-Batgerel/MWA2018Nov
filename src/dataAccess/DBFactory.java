package dataAccess;

import java.sql.SQLException;

import domain.Movie;
import domain.MovieScheduledFactory;
import javafx.scene.shape.MoveTo;

public final class DBFactory {

	public static Boolean login(String uname, String password) {
		try {
			DBConnection Conn = new DBConnection();
			return Conn.getPassByUname(uname).equals(password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean addMovie(Movie mov) {
		try {
			DBConnection Conn = new DBConnection();
		//	return Conn.getPassByUname(uname).equals(password);
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
