package taskXI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public interface Parser {

    default List<File> findLogs() {
        //поиск файлов xml в папке и добавление их в коллекцию list
        List<File> list = new ArrayList<>();
        return list;
    }

    default UserLogs createUserLogs()
    {
        //извлечение данных из файлов xml с использованием xsd (посредством xerces)


        return null;
    }

    void writeToFile();
    //xsd схема для выгрузки и запись в формат xml


}

