import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {
    String dbURL = "jdbc:sqlserver://DESKTOP-OGFK027;user=user;password=user1234;encrypt=true;trustServerCertificate=true";
    Connection conn;
    Statement statement;

    public DBconnection() throws SQLException {
        conn = DriverManager.getConnection(dbURL);
        statement = conn.createStatement();
    }
    @Test
    public void connection() throws SQLException {
        Statement statement1 = conn.createStatement();
        Boolean bool = statement1.execute("SELECT * FROM  Persons  ");
        System.out.println(bool);
        Statement statement2 = conn.createStatement();
        bool = statement2.execute(
                "  UPDATE [master].[dbo].[Persons]\n" +
                "  SET LastName = 'Giga'\n" +
                "  WHERE PersonID = 5 ");
        System.out.println(bool);
        //------------------
        int value = statement1.executeUpdate("\n" +
                "  UPDATE [master].[dbo].[Persons]\n" +
                "  SET LastName = 'Tamari'\n" +
                "  WHERE LastName = 'Tamari'");
        System.out.println(value);
        //----------------
        ResultSet result = statement.executeQuery("SELECT Top 1 * FROM  Persons");
        while(result.next()){
            System.out.println(result.getString(1));
            System.out.println(result.getString("LastName"));
        }

        PreparedStatement statement = conn.prepareStatement("INSERT Persons VALUES (?, ?, 'Mumladze','Adress', 'Tbilisi') ");
        statement.setInt(1, 18);
        statement.setString(2, "Nia");
        statement.setString(2, "tazo");
        statement.execute();
        int b = 5;
        String g = String.valueOf(2323);
        if (conn != null) {
            System.out.println("Connected");
        }
    }
    @Test
    public void name() {
        System.out.println( 5 + 'A' );
        System.out.println( 5 + "A" );
        //int + char = String, int ,String
        // int + String = String
        //int 4 byte
        //double 8 byte
        //String 8 byte
        //char 2 byte
    }
}
