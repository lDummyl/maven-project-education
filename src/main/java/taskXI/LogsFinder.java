package taskXI;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public interface LogsFinder {

    default List<File> findLogs(String dirName) {
        //поиск файлов xml в папке и добавление их в коллекцию list
        File dir = new File(dirName);
        return Arrays.asList(Objects.requireNonNull(dir.listFiles((dir1, filename) -> filename.endsWith(".xml"))));
    }



}

