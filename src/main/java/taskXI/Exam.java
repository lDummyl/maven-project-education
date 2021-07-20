package taskXI;

/*

	После реализации всех задач, не более 1 недели на каждую(~2 мес) будет выдано
	тестовое задание на многопоточность из реального опыта трудоустройства,
	после его реализации 10 задач по SpringBoot,
	успех в которых позволит всерьез рассчитывать на трудоустройство на позицию Junior.

*/

import java.util.List;

public class Exam {
    public static void main(String[] args) {
        UserLogsProcessing userLogsProcessing = new UserLogsProcessing();
        userLogsProcessing.createUserLogs();
    }
}
