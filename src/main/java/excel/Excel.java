package excel;


import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    public static void main(String[] args) throws IOException {
        Download download = new Download();
        download.getValue();
        Unload unload = new Unload();
        unload.test(new FileOutputStream("C:\\java\\fin.xlsx"));

//        Workbook outputExcelBook = new XSSFWorkbook(new FileOutputStream("С:\\java\\book.xlsx"));
//        outputExcelBook.createSheet("Сентябрь");



    }
}
