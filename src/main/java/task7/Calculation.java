package task7;

import java.util.*;

public class Calculation {
    List <CirculatingPump> listOfPumps = new ArrayList<>();
    {
     listOfPumps.add(new CirculatingPump("solar 15-80", new ArrayList<>
             (Arrays.asList(new HydraulicCharacteristics(0.3f, 7.0f, 180),
                     new HydraulicCharacteristics(0.33f,7.8f, 180))), 5395.98));
     listOfPumps.add(new CirculatingPump("solar 25-40", new ArrayList<>(
             Arrays.asList(new HydraulicCharacteristics(1.75f, 3.3f, 40),
             new HydraulicCharacteristics(2.1f, 3.7f, 50))), 3386.04));
     listOfPumps.add(new CirculatingPump("solar 25-60", new ArrayList<>(
             Arrays.asList(new HydraulicCharacteristics(2.0f, 5.0f, 65),
                     new HydraulicCharacteristics(2.55f, 5.6f, 80))),4170.00));
     listOfPumps.add(new CirculatingPump("solar 25-120", new ArrayList<>(
             Arrays.asList(new HydraulicCharacteristics(2.25f,9.8f,  180),
                     new HydraulicCharacteristics(3.25f, 11.7f, 180))), 8201.00));
     listOfPumps.add(new CirculatingPump("wilo Star-RS 15-4", new ArrayList<>(
             Arrays.asList(new HydraulicCharacteristics(2.1f, 2.8f),
                     new HydraulicCharacteristics(3.7f, 3.5f),
                     new HydraulicCharacteristics(3.7f, 4.9f))), 5835.22));
        listOfPumps.add(new CirculatingPump("wilo Star-RS 15-6", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.1f, 4.1f),
                        new HydraulicCharacteristics(2.95f, 5.1f),
                        new HydraulicCharacteristics(3.9f, 5.5f))), 6713.70));
        listOfPumps.add(new CirculatingPump("wilo Star-RS 25-2", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(1.75f, 1.45f),
                        new HydraulicCharacteristics(2.25f, 1.8f),
                        new HydraulicCharacteristics(2.45f, 2.0f))), 5673.98));
        listOfPumps.add(new CirculatingPump("wilo Star-RS 25-4", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.1f, 2.7f),
                        new HydraulicCharacteristics(2.7f, 3.5f),
                        new HydraulicCharacteristics(3.8f, 3.9f))), 5754.60));
        listOfPumps.add(new CirculatingPump("wilo Star-RS 25-6", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.15f, 4.1f),
                        new HydraulicCharacteristics(2.95f, 5.1f),
                        new HydraulicCharacteristics(3.85f, 5.5f))), 6713.70));
        listOfPumps.add(new CirculatingPump("wilo Star-RS 25-7", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.3f, 4.3f),
                        new HydraulicCharacteristics(3.6f, 6.1f),
                        new HydraulicCharacteristics(5.25f, 7.0f))), 7433.72));
    }

    public List<CirculatingPump> getSorted (List <CirculatingPump> list){
       list.sort(Comparator.comparing(pump -> pump.price));
       return list;
    }




    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        System.out.println(calculation.getSorted(calculation.listOfPumps));


    }


}
