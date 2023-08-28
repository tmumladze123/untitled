import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnection {

    public DBconnection() throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    @Test
    public void connection() throws SQLException {
        String dbURL = "jdbc:sqlserver://DESKTOP-OGFK027;user=user;password=user1234;encrypt=true;trustServerCertificate=true";
        Connection conn = DriverManager.getConnection(dbURL);
        PreparedStatement statement = conn.prepareStatement("INSERT Persons VALUES (1, 'Tamari', 'Mumladze','Adress', 'Tbilisi') ");
        statement.execute();
        if (conn != null) {
        System.out.println("Connected");
        }
    }
}
