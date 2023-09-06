import data.ThirdHomeworkData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class ThirdHomeWork {
    ThirdHomeworkData thirdHomeworkData = new ThirdHomeworkData();

    public ThirdHomeWork() throws SQLException {
    }

    @BeforeClass
    public void createTable(){
        thirdHomeworkData.dropTable();
        thirdHomeworkData.createTable();
    }
    @Test
    public void insertDataInTable() throws SQLException {
        thirdHomeworkData.insertDataInTable();
        thirdHomeworkData.getDataFromPersons();
    }
}
