package excel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Excel {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        List <FinOperation> finOperations = fileReader.getFinOperations();
        FileWriter fileWriter = new FileWriter();
        FileOutputStream file = new FileOutputStream("C:\\java\\book.xlsx");
        FileOutputStream file2 = new FileOutputStream("C:\\java\\2.xlsx");
//        fileWriter.writeToFile(finOperations, file);
        fileWriter.writePaymentsFromIC(finOperations, file2);
    }

}

