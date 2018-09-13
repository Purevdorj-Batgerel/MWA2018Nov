package dataAccess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import domain.Hall;
import domain.Movie;

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

    public static int addMovie(Movie mov) {
        int insertID = -1;
        try {
            DBConnection conn = new DBConnection();
            insertID = conn.addMovieByObject(mov);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertID;
    }

    public static List<Movie> getMovieList() {
        try {
            DBConnection connection = new DBConnection();
            return connection.getMovieList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Hall> getHallList() {
        try {
            DBConnection connection = new DBConnection();
            return connection.getHallList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Map<String, Object> getMovieData(int movieId) {
        try {
            DBConnection connection = new DBConnection();
            return connection.getMovieDetail(movieId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
