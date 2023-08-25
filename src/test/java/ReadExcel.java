import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void takeDataFromExcel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/TestData.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Cell cell = sheet.getRow(0).getCell(0); // Replace with desired row and column
        String value = cell.getStringCellValue();
        System.out.printf(value);
       /* Cell cell1 = sheet.getRow(1).createCell(1); // Replace with desired row and column
        cell1.setCellValue("New Value");
        FileOutputStream fileOutputStream = new FileOutputStream("path/to/your/excel/file.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();*/
    }
}
