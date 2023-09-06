package data;

import common.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static common.DBConnection.changeData;
import static common.DBConnection.getData;

public class ThirdHomeworkData {
    DBConnection dbConnection = new DBConnection();

    String dropTable = "DROP TABLE Persons";
    String createTable = "CREATE TABLE Persons (\n" +
            "    PersonID int,\n" +
            "    LastName varchar(255),\n" +
            "    FirstName varchar(255),\n" +
            "    Email varchar(255),\n" +
            "    Age varchar(255),\n" +
            "\tSalary varchar(255),\n" +
            "\tDepartment varchar(255)\n" +
            ");";
    String insertData = "INSERT INTO Persons VALUES (?,?,?,'Email@gmail.com','12','1000','chachua')";
    String getData = "SELECT * FROM Persons";

    public ThirdHomeworkData() throws SQLException {
    }

    public void dropTable() {
        changeData(dropTable);
    }

    public void insertDataInTable() {
        for (int i = 0; i < 3; i++) {
            dbConnection.changeDataWithPrepareStatement(insertData, List.of(String.valueOf(i), "Tazo" + i, "butskhrikidze" + i * 4));
        }
    }

    public void createTable() {
        changeData(createTable);
    }

    public void getDataFromPersons() throws SQLException {
        String name = null;
        ResultSet set = getData(getData);
        while (set.next()){
         name = set.getString("FirstName");
            System.out.println(name);
        }
    }

}
