import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnection {

    @Test
    public void connect() throws SQLException {
        String dbURL = "jdbc:sqlserver://DESKTOP-OGFK027;user=user;password=user1234;encrypt=true;trustServerCertificate=true";
        Connection conn = DriverManager.getConnection(dbURL);
        PreparedStatement statement = conn.prepareStatement("INSERT Persons VALUES (1, 'Tamari', 'Mumladze','Adress', 'Tbilisi') ");
        statement.execute();
        if (conn != null) {
        System.out.println("Connected");
        }
    }
}
