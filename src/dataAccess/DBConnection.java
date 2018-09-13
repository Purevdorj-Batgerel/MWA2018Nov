package dataAccess;

import domain.AgeRating;
import domain.Movie;
import domain.MovieScheduledFactory;
import domain.TypeMovie;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:Cinema;create=true";

    private static Connection conn = null;
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

    Statement createStatement() {
        try {
            return stmt = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void initialData() {
        initialData.createTables(conn);
    }


    String getPassByUname(String uname) {
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

    public int addMovieByObject(Movie movie) {
        int insertID = -1;
        try {

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO movies(name, type, duringtime, rate, director, picture, description) VALUES(" +
                    "'" + movie.getName() + "', " +
                    "'" + movie.getType().toString() + "', " +
                    movie.getDuringTime() + ", " +
                    "'" + movie.getRate().toString() + "', " +
                    "'" + movie.getDirector() + "', " +
                    "'" + movie.getPicture() + "', " +
                    "'" + movie.getDescription() + "'" +
                    ")", new String[] { "ID_COLUMN"});

            preparedStatement.executeUpdate();

            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                insertID = resultSet.getInt(1);
            }

            stmt.close();
            return insertID;
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return insertID;
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

    public Map<String, String> findUser(String username) {
        Map<String, String> userInfo = null;
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM staffs WHERE username = '" + username + "'");

            if (results.next()) {
                userInfo = new HashMap<>();
                userInfo.put("password", results.getString("password"));
                userInfo.put("firstName", results.getString("fname"));
                userInfo.put("lastName", results.getString("lname"));
                userInfo.put("type", results.getString("type"));
                userInfo.put("dob", results.getString("dob"));
            }
            results.close();
            stmt.close();

        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return userInfo;
    }

    List<Movie> getMovieList() {
        List<Movie> movieList = new ArrayList<>();

        try {
            stmt = conn.createStatement();

//            ResultSet results = stmt.executeQuery("SELECT * from movies INNER JOIN schedules ON movies.id = ");
            ResultSet results = stmt.executeQuery("SELECT * from movies");

            while (results.next()) {
                Movie movie = MovieScheduledFactory.createMovie(
                        results.getInt("id"),
                        results.getString("name"),
                        TypeMovie.valueOf(results.getString("type")),
                        results.getInt("duringtime"),
                        results.getString("director"),
                        AgeRating.valueOf(results.getString("rate")),
                        results.getString("description"),
                        results.getString("picture")
                );
                movieList.add(movie);
            }
            results.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    Map<String, Object> getMovieDetail(int id) {
        Map<String, Object> ret = null;
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM movies WHERE id = " + id);

            if (results.next()) {
                ret = new HashMap<>();
                ret.put("name", results.getString("name"));
                ret.put("type", results.getString("type"));
                ret.put("duringtime", results.getInt("duringtime"));
                ret.put("rate", results.getString("rate"));
                ret.put("director", results.getString("director"));
                ret.put("description", results.getString("description"));
                ret.put("picture", results.getString("picture"));
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return ret;
    }
}
