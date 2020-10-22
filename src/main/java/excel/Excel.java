package excel;


import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    public static void main(String[] args) throws IOException {
        Download download = new Download();
        Unload unload = new Unload();
        download.getValue();
        unload.test(new FileOutputStream("C:\\java\\fin.xlsx"));


    }
}
