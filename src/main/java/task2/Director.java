package task2;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Director {

    public static void giveBonus(Map<String, Double> kpis){
        double max = -1.0;
        String winner = "";
        ArrayList<String> winners = new ArrayList<>();

        if (kpis.size() >= 5) {
            for (Map.Entry<String, Double> pair : kpis.entrySet()) {


                Double currentMaxKPI = pair.getValue();
                if (currentMaxKPI > max) {
                    max = currentMaxKPI;
                }
            }
            for (Map.Entry<String, Double> pair : kpis.entrySet()) {
                if (pair.getValue() == max){
                    String winnersName = pair.getKey();
                    winners.add(winnersName);
                }
            }
            System.out.println("Director: \"По результатам таблицы сотрудник " + winners + " получит премию\"");
        }
        else
        {
            System.out.println("Director: \"Сотрудников должно быть не меньше 5! \"");
        }
    }

    public static void chooseCandidate(Map<String, Double> expYears) {
        // TODO: 1/16/20 implement
        double max = -1.0;
        String futureCandidate = "";
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> winners = new ArrayList<>();


        if (expYears.size() >= 5) {
            for (String s : expYears.keySet()) {
                values.add(expYears.get(s));
            }
            double result = Collections.max(values);   //нашли максимальный опыт

            // Xотим найти ключ от максимального опыта
            for (String key : expYears.keySet()) {
                double res = expYears.get(key);
                if (key != null) {
                    if (result == res) {
                        futureCandidate = key;// нашли ключ при котором максимальный опыт у кандидата
                        winners.add(key);
                    }
                }
            }

            System.out.println("Director: \"Работу секретарем получает " + winners + "\"");
        }
    }
}

