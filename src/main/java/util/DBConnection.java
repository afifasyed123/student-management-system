package util;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String pass = "YOUR_PASSWORD";

        return DriverManager.getConnection(url, user, pass);
    }
}