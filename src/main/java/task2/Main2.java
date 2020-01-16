package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String petya = "Petya";
        int petyaKpi = 2;

        list.add(petya);
        String petyaAgain = list.get(0);
        System.out.println("petyaAgain = " + petyaAgain);

        map.put(petya, petyaKpi);

        Integer kpiAgain = map.get(petya);
        System.out.println("kpiAgain = " + kpiAgain);


    }
}
