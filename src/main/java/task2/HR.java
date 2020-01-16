package task2;

import java.util.Map;

public class HR extends Manager{

    public String createPhrase1(int inEmployees){
        String phrase1 = "HR: \"Manager A, look at the list of " + inEmployees + " employee and fill up their KPI\" ";
        return phrase1;
    }

    String phrase0 = "Please, input the number of new employees:  ";
   // String phrase1 = "HR: \"Manager A, look at the list of employees and fill up their KPI\" ";
    String phrase2 = "HR: \"Thank you, Manager A, I'll prepare this information to the Director.\"";
    String phrase3 = "HR: \"Mr Director, check this table with employee's KPI: \"";


    public void createTable(Map<String, Double> kpis) {
        printHeader();
        for (Map.Entry<String, Double> pair : kpis.entrySet()) { // iter
            System.out.println("|  "+ pair.getKey() +"                "+ pair.getValue());
        }
        System.out.println("+------------------+---------+");
    }

    private void printHeader() {
        System.out.println("+------------------+---------+");
        System.out.println("|      Name        +   KPI   +");
        System.out.println("+------------------+---------+");
    }
}
