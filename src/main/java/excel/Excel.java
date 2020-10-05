package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Excel {
    public static void main(String[] args) throws IOException {
        Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\Statements.xlsx"));
        Sheet myExcelSheet = myExcelBook.getSheetAt(0);
        for (int i = 0; i < myExcelBook.getNumberOfSheets(); i++) {
            myExcelBook.getSheetAt(i);
            for (int j = 20; ; j++)
            {
                Row row = myExcelSheet.getRow(j);
                Cell date = row.getCell(3);
//                Date date1 = date.getDateCellValue();
                if (!date.getStringCellValue().equals("")) {
                    System.out.println(date);
                    Cell entrance = row.getCell(18);
                    System.out.println(entrance);
                    Cell description = row.getCell(21);
                    String s = description.getStringCellValue();
                    int x = s.indexOf("Комиссия");
                    int begin = x + 9;
                    int last = s.indexOf(". Возврат покупки");
                    String commission = s.substring(begin, last);
                    Double comm = Double.parseDouble(commission);
                    System.out.println(comm);
                }
            }
        }
    }
}

//21 строка - дата
//18 стр - сумма
//21 стр - расшифровка