package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\2020.xlsx"));

    Sheet myExcelSheet;

    public FileReader() throws IOException {
    }

    public List<FinOperation> getFinOperations() throws IOException {
        ArrayList<FinOperation> finOperations = new ArrayList<>();
        for (int i = 0; i < myExcelBook.getNumberOfSheets(); i++) {
            myExcelSheet = myExcelBook.getSheetAt(i);
            for (int j = 20; j < myExcelSheet.getPhysicalNumberOfRows(); j++) {
                Row row = myExcelSheet.getRow(j);
                Cell rawDate = row.getCell(3);
                if (!rawDate.getStringCellValue().equals("")) {
                    Cell payer = row.getCell(10);
                    Cell income = row.getCell(18);
                    Cell outcome = row.getCell(15);
                    Cell description = row.getCell(21);
                    finOperations.add(new FinOperation(rawDate, payer, income, outcome, description));
                }
            }
        }
        myExcelBook.close();
        return finOperations;
    }

}
