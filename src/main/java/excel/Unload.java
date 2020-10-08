package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class Unload {

    public void test () throws IOException {
        Workbook outputExcelBook = new XSSFWorkbook();
        Sheet outputSheet = outputExcelBook.createSheet("8");
        Row row = outputSheet.createRow(1);
        Cell name = row.createCell(1);
        name.setCellValue(52256354);
        outputExcelBook.write(new FileOutputStream("C:\\java\\fin.xlsx"));
    }





}
