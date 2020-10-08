package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Download {
    Workbook myExcelBook;

    {
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\Statements.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Sheet myExcelSheet;

    public void getValue() throws IOException {
        for (int i = 0; i < myExcelBook.getNumberOfSheets(); i++) {
            myExcelSheet = myExcelBook.getSheetAt(i);
            for (int j = 20; j < myExcelSheet.getPhysicalNumberOfRows(); j++) {
                Row row = myExcelSheet.getRow(j);
                Cell date = row.getCell(3);
//                Date date1 = date.getDateCellValue();
                if (!date.getStringCellValue().equals("")) {
                    System.out.println(date);
                    Cell entrance = row.getCell(18);
                    System.out.println(entrance);
                    Cell description = row.getCell(21);
                    String s = description.getStringCellValue();
                    if (s.contains("Комиссия")) {
                        int x = s.indexOf("Комиссия");
                        int begin = x + 9;
                        int last = s.indexOf(". Возврат покупки");
                        String commission = s.substring(begin, last);
                        Double comm = Double.parseDouble(commission);
                        System.out.println(comm);
                    }
                }
                myExcelBook.close();
            }
        }
    }
}
