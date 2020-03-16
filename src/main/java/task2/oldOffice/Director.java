package task2.oldOffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Director {

    public static final int enoughCandidates1 = 5;
    String name;
    private int enoughCandidates;

    public Director(int enoughCandidates, String name) {
        this.enoughCandidates = enoughCandidates;
        this.name = name;
    }

    public void giveBonus(Map<String, Double> kpis) {
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
                if (pair.getValue() == max) {
                    String winnersName = pair.getKey();
                    winners.add(winnersName);
                }
            }
            System.out.println("Director: \"По результатам таблицы сотрудник " + winners + " получит премию\"");
        } else {
            System.out.println("Director: \"Сотрудников должно быть не меньше 5! \"");
        }
    }

    public Secretary chooseCandidate(List<Secretary> candidates) {
        ArrayList<Secretary> winners = new ArrayList<>();
        Map<Integer, Secretary> expCandidates = new HashMap<>();
        for (Secretary candidate : candidates) {
            expCandidates.put(candidate.experienceYears, candidate);
        }

        if (candidates.size() >= enoughCandidates) {
            int result = Collections.max(expCandidates.keySet());   //нашли максимальный опыт
            // Xотим найти ключ от максимального опыта
            for (Secretary secretary : candidates) {
                if (secretary.experienceYears == result) {
                    winners.add(secretary);
                }
            }
            Secretary secretary = winners.get(0);
            System.out.println("Director: \"Работу секретарем получает " + secretary.name + "\"");
            return secretary;
        } else {
            return null;
        }
    }
}

