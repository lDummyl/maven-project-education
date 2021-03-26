package task5;


/*
  Использовать отчет из прошлого задания и проанализировать
  Статистика самые частые вопросы
  Сколько всего пришлось ждать по времени когда оракул отдыхал.
  Сколько раз оракул нахамил
 */


import task3.Oracle;

import java.io.IOException;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        Statistic statistic = new Statistic();
        Map<String, Integer> questionStatistic = statistic.getQuestionStatistic();
        System.out.println("оракул ударил " + statistic.qtyInvalidAnswers(Oracle.Action.HIT) + " раз");
        System.out.println("Оракул спал " + statistic.qtyTimeOracleSleep() + " секунд");
        System.out.println(statistic.getTopFrequencyQuestions(questionStatistic, 5));

    }

}
