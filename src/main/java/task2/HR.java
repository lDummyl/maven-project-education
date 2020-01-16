package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HR extends Manager {

    public String createPhrase1(int inEmployees) {
        String phrase1 = "HR: \"Manager A, look at the list of " + inEmployees + " employee and fill up their KPI\" ";
        return phrase1;
    }

    String phrase0 = "Please, input the number of new employees:  ";
    // String phrase1 = "HR: \"Manager A, look at the list of employees and fill up their KPI\" ";
    String phrase2 = "HR: \"Thank you, Manager A, I'll prepare this information to the Director.\"";
    String phrase3 = "HR: \"Mr Director, check this table with employee's KPI: \"";


    ArrayList<Secretary> list = new ArrayList<Secretary>();

    public void createTable(Map<String, Double> kpis, Map<String, Double> expYears) {
        printHeader();

        for (Map.Entry<String, Double> pair0 : expYears.entrySet()) {
            for (Map.Entry<String, Double> pair : kpis.entrySet()) { // iter
                if (pair0.getKey().equals(pair.getKey())) {
                    System.out.println("|  " + pair.getKey() + "               " + pair.getValue()
                            + "           " + pair0.getValue());
                }
            }
            System.out.println("+------------------+-----------+-------------");
        }
    }

    private void printHeader() {
        System.out.println("+------------------+-----------+-------------");
        System.out.println("|      Name        +    KPI    +  Exp Years  |");
        System.out.println("+------------------+-----------+-------------");
    }

    public List<Secretary> conciderCandidate(Secretary human) {
        // TODO: 1/16/20 implement
        list.add(human);
        return list;
    }
}
