package excel;

import org.apache.poi.EmptyFileException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelProcessor {

    public static void main(String[] args)  {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<FinOperation> finOperations = null;
        try {
            finOperations = fileReader.getFinOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\java\\book.xlsx");
            fileWriter.writeToFile(finOperations, fileOutputStream );
        }
        catch (RuntimeException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }



    }
}
