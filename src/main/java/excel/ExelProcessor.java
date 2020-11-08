package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExelProcessor {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        List<FinOperation> finOperations = fileReader.getFinOperations();
        FileWriter fileWriter = new FileWriter();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\java\\z.xlsx");
            fileWriter.writeToFile(finOperations, fileOutputStream );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
