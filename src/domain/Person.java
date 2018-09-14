package domain;

import dataAccess.DBConnection;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class Person implements iPerson, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String accountType;

    public Person() {

    }

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;

    }

    @Override
    public boolean login(String username, String password) {
        try {
//            DBFactory.login()
            DBConnection Conn = new DBConnection();
            Map<String, String> user = Conn.findUser(username);
            if (user.get("password").equals(password)) {
                this.firstName = user.get("firstName");
                this.lastName = user.get("lastName");
                this.accountType = user.get("type");
//                this.dob = LocalDate.parse(user.get("dob"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return String.format("Name: %s, %s DOB: %s", firstName, lastName, dob);
    }

}
