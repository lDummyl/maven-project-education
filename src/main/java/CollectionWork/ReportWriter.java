package CollectionWork;

import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    public void writeReport(String str){

        try(FileWriter writer = new FileWriter("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\CollectionWork\\Report",true))
        {
            writer.write(str+"\n");
        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }
    }
}

