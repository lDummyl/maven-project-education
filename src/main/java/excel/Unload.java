package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class Unload {
    Download download = new Download();
    Workbook outputExcelBook = new XSSFWorkbook();
    Sheet outputSheet;

    public Unload() throws IOException {
    }

    public void test (FileOutputStream file) throws IOException {

         outputSheet = outputExcelBook.createSheet("8");
        for (int i = 1; i<download.dates.size(); i++) {
            Row row = outputSheet.createRow(i);
            for (int j = 0; j<download.dates.size() ; j++) {
                Cell name = row.createCell(j);
                name.setCellValue(String.valueOf(download.dates.get(j)));

            }
        }
        outputExcelBook.write(file);
        outputExcelBook.close();
    }

}
