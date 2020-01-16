package task2;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
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
}

