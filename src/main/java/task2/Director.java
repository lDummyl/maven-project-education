package task2;

import org.w3c.dom.ls.LSOutput;

import java.util.Map;

public class Director {

    public void giveBonus(Map<String, Double> kpis){
        double max = -1.0;
        String winner = "";

        if (kpis.size() >= 5) {
            for (Map.Entry<String, Double> pair : kpis.entrySet()) {


                Double value = pair.getValue();
                if (value > max) {
                    max = value;
                    winner = pair.getKey();  //Что делать, если два максимальных КПИ?
                }
            }
            System.out.println("Director: \"По результатам таблицы сотрудник " + winner + " получит премию\"");
        }
        else
        {
            System.out.println("Director: \"Сотрудников должно быть >= 5\"");
        }
    }
}

