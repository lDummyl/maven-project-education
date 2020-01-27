package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {


        /*Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String petya = "Petya";
        int petyaKpi = 2;

        list.add(petya);
        String petyaAgain = list.get(0);
        System.out.println("petyaAgain = " + petyaAgain);

        map.put(petya, petyaKpi);

        Integer kpiAgain = map.get(petya);
        System.out.println("kpiAgain = " + kpiAgain);

        Integer integer = new Integer(3);
        int i = integer.compareTo(4);
        System.out.println(i); */


        for (int i1 = 1; i1 <= 100; i1++){

            if (i1 % 3 == 0 && !(i1 % 5 == 0)){
                System.out.print(" " + "Bazz");
            }
            else if (i1 % 5 == 0 && !(i1 % 3 == 0)){
                System.out.print(" "+ "Jazz");
            }
            else if ((i1 % 3 == 0) && (i1 % 5 == 0)){
                System.out.print(" "+ "Mazz");
            }
            else{
                System.out.print(" " + i1);
            }
        }

        }
    }


