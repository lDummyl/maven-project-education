package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExelProcessor {

    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader();
//        List<FinOperation> finOperations = fileReader.getFinOperations();

        Unload unload = new Unload();
        unload.test();


    }
}
