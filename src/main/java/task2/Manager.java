package task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {

    Map<String, Double> kpis = new HashMap<>();

    public void inputKPI(Secretary secretary){
        System.out.print("Input KPI of employee "+ secretary.name +": ");
        Scanner input = new Scanner(System.in);
        double kpi = input.nextDouble();
        kpis.put(secretary.name, kpi);
    }

    Manager(){

    }

}
