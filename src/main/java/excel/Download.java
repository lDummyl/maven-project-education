package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Download {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\Statements.xlsx"));

    Sheet myExcelSheet;
    ArrayList dates = new ArrayList<>();
    ArrayList entrances = new ArrayList<>();

    public Download() throws IOException {
    }

    public void getValue() throws IOException {
        for (int i = 0; i < myExcelBook.getNumberOfSheets(); i++) {
            myExcelSheet = myExcelBook.getSheetAt(i);
            for (int j = 20; j < myExcelSheet.getPhysicalNumberOfRows(); j++) {
                Row row = myExcelSheet.getRow(j);
                Cell date = row.getCell(3);
                dates.add(date);
//                for (Object cell : dates) {
//                    System.out.println(cell);                }
                if (!date.getStringCellValue().equals("")) {
//                    System.out.println(date);
                    Cell entrance = row.getCell(18);
//                    entrances.add(entrance);
                    System.out.println(entrance);
                    Cell description = row.getCell(21);
                    String s = description.getStringCellValue();
                    if (s.contains("Комиссия")) {
                        int x = s.indexOf("Комиссия");
                        int begin = x + 9;
                        int last = s.indexOf(". Возврат покупки");
                        String commission = s.substring(begin, last);
                        Double comm = Double.parseDouble(commission);
//                        System.out.println(comm);
                    }
                }
                myExcelBook.close();
            }
        }
    }
}
