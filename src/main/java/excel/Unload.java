package excel;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Unload {
    Download download = new Download();
    Workbook outputExcelBook = new XSSFWorkbook();
    Sheet outputSheet;
    List dates = Arrays.asList("01.08.2020", "02.08.2020", "03.08.2020", "04.08.2020", "05.08.2020");
    List entrance =  Arrays.asList(1000.00, 50.00, 99.00, 11.00, 34.00);
    List commission = Arrays.asList(20.00, 1.00, 2.00, 0.2, 0.7);
    ArrayList list = new ArrayList();
    HashMap <List,ArrayList<List>> acquiring = new HashMap<>();

    {
            list.add(entrance);
            list.add(commission);
        acquiring.put(dates, list);
    }
    List list2 = download.dates;



    public Unload() throws IOException {
    }

    public void test (FileOutputStream file) throws IOException {

         outputSheet = outputExcelBook.createSheet("8");
        for (Map.Entry<List, ArrayList<List>> entry : acquiring.entrySet()) {
            List list = entry.getKey();
            List list2 = entry.getValue().get(0);
            List list3 = entry.getValue().get(1);
            int i =1;
                for (Object o : list) {
                   Row row = outputSheet.createRow(i);
                    int j = 0;
                    Cell date = row.createCell(j);
                    date.setCellValue((String) o);
                    i++;
                }
                i = 1;
                for (Object o : list2) {
                    Row row = outputSheet.getRow(i);
                    int j = 3;
                    Cell entrance = row.createCell(j);
                    entrance.setCellValue((Double) o);
                    i++;
                }
                i = 1;
                for (Object o : list3) {
                    Row row = outputSheet.getRow(i);
                    int j = 4;
                    Cell entrance = row.createCell(j);
                    entrance.setCellValue((Double) o);
                    i++;
                }


        }

        outputExcelBook.write(file);
        outputExcelBook.close();
    }

}
