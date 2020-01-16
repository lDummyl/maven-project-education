package task2;

import java.util.*;

public class Manager {

    Map<String, Double> kpis = new TreeMap<>();
    Map<String, Double> expYears = new TreeMap<>();

    public void inputKPI(Secretary secretary){
        System.out.println("");

        System.out.print("Input KPI of employee "+ secretary.name +": ");
        Scanner input = new Scanner(System.in);
        double kpi = input.nextDouble();
        kpis.put(secretary.name, kpi);

        System.out.print("Input year(s) of work experience: ");
        Scanner in = new Scanner(System.in);
        double years = in.nextDouble();
        expYears.put(secretary.name, years);

    }
}
