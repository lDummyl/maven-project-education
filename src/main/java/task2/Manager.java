package task2;

import java.util.*;

public class Manager {

    Map<String, Double> kpis = new TreeMap<>();

    public void inputKPI(Secretary secretary){
        System.out.print("Input KPI of employee "+ secretary.name +": ");
        Scanner input = new Scanner(System.in);
        double kpi = input.nextDouble();
        kpis.put(secretary.name, kpi);
    }

    Manager(){

    }

}
