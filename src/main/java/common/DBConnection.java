package common;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.sql.*;
import java.util.List;

public class DBConnection {
    String dbURL = "jdbc:sqlserver://DESKTOP-OGFK027;user=user;password=user1234;encrypt=true;trustServerCertificate=true";
    Connection conn;
    static Statement statement;
    static PreparedStatement preparedStatement ;
    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection(dbURL);
        statement = conn.createStatement();
    }
    public static void changeData(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeDataWithPrepareStatement(String query, List<String> list) {
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,list.get(0));
            preparedStatement.setString(2,list.get(1));
            preparedStatement.setString(3,list.get(2));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet getData(String query){
        ResultSet set;
        try {
            set = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return set;
    }
}
