package excel;


import java.io.IOException;

public class Excel {
    public static void main(String[] args) throws IOException {
        Download download = new Download();
        download.getValue();
        Unload unload = new Unload();
        unload.test();

//        Workbook outputExcelBook = new XSSFWorkbook(new FileOutputStream("С:\\java\\book.xlsx"));
//        outputExcelBook.createSheet("Сентябрь");



    }
}
