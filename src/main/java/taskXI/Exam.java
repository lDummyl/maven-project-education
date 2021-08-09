package taskXI;

/*

	После реализации всех задач, не более 1 недели на каждую(~2 мес) будет выдано
	тестовое задание на многопоточность из реального опыта трудоустройства,
	после его реализации 10 задач по SpringBoot,
	успех в которых позволит всерьез рассчитывать на трудоустройство на позицию Junior.

*/


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Exam {
    public static void main(String[] args) {
        UserLogsProcessing userLogsProcessing = new UserLogsProcessing();
        Map <LocalDate, List<OutgoingFile>> map = userLogsProcessing.getMapForWriteToFile();
        userLogsProcessing.writeToFile(map);

    }
}

