package task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> allTypes = new ArrayList<>();
        String s = reader.readLine();
        while (!s.isEmpty()) {
            allTypes.add(s);
            s = reader.readLine();
        }
        return allTypes;
    }
}
