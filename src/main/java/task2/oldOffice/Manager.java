package task2.oldOffice;

import java.util.*;

public class Manager {

    Map<String, Double> kpis = new TreeMap<>();
    Map<String, Integer> expYears = new TreeMap<>();

    public void inputKPI(Secretary secretary){
        System.out.println("");

        System.out.print("Input KPI of employee "+ secretary.name +": ");
        Scanner input = new Scanner(System.in);
        double kpi = input.nextDouble();
        secretary.kpi = kpi;
        kpis.put(secretary.name, kpi);


        System.out.print("Input year(s) of work experience: ");
        Scanner in = new Scanner(System.in);
        int years = in.nextInt();
        secretary.experienceYears = years;
        expYears.put(secretary.name, years);

    }
}
