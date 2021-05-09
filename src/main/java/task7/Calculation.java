package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task6.Interpolator;
import task6.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Calculation {
    List<CirculatingPump> listOfPumps = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();


    {
        listOfPumps.add(new CirculatingPump("solar 15-80", new ArrayList<>
                (Arrays.asList(new HydraulicCharacteristics(0.3f, 7.0f, 180),
                        new HydraulicCharacteristics(0.33f, 7.8f, 180))), 5395.98));
        listOfPumps.add(new CirculatingPump("solar 25-40", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(1.75f, 3.3f, 40),
                        new HydraulicCharacteristics(2.1f, 3.7f, 50))), 3386.04));
        listOfPumps.add(new CirculatingPump("solar 25-60", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.0f, 5.0f, 65),
                        new HydraulicCharacteristics(2.55f, 5.6f, 80))), 4170.00));
        listOfPumps.add(new CirculatingPump("solar 25-120", new ArrayList<>(
                Arrays.asList(new HydraulicCharacteristics(2.25f, 9.8f, 180),
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

    private List<CirculatingPump> getSorted(List<CirculatingPump> list) {
        list.sort(Comparator.comparing(pump -> pump.price));
        return list;
    }

    public List<Float> getX() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Float> x = new ArrayList<>();
        while (true) {
            if (!reader.readLine().isEmpty()) {
                x.add(Float.parseFloat(reader.readLine()));
            } else break;
        }
        return x;
    }

    public CirculatingPump getSuitablePump(float x) {
        List<CirculatingPump> list = getSorted(listOfPumps);
        Interpolator interpolator = new Interpolator();
        List<Point> points = new ArrayList<>();
        for (CirculatingPump pump : list) {
            List<HydraulicCharacteristics> characteristics = pump.characteristics;
            for (HydraulicCharacteristics characteristic : characteristics) {
                points.add(new Point(characteristic.getCapacity(), characteristic.getPressure()));
            }
            interpolator.setPoints(points);
            float y = interpolator.getY(x);
            for (CirculatingPump circulatingPump : list) {
                for (int j = 0; j < characteristics.size(); j++) {
                    if (y < circulatingPump.characteristics.get(j).getPressure())
                        return circulatingPump;
                }
            }
        }
        return null;
    }

    public List<CirculatingPump> getSuitablePump(List<Float> x) {
        List<CirculatingPump> list = getSorted(listOfPumps);
        Interpolator interpolator = new Interpolator();
        List<Point> points = new ArrayList<>();
        List<CirculatingPump> suitablePumps = new ArrayList<>();
        for (CirculatingPump pump : list) {
            List<HydraulicCharacteristics> characteristics = pump.characteristics;
            for (HydraulicCharacteristics characteristic : characteristics) {
                points.add(new Point(characteristic.getCapacity(), characteristic.getPressure()));
            }
            interpolator.setPoints(points);
            for (Float floatX : x) {
                float y = interpolator.getY(floatX);
            for (CirculatingPump circulatingPump : list) {
                for (int j = 0; j < characteristics.size() - 1; j++) {
                        if (y < circulatingPump.characteristics.get(j).getPressure())
                            suitablePumps.add(circulatingPump);
                    }
                }
            }
        }
        return suitablePumps;
    }

    public void getJsonFormatFile(File file, List<CirculatingPump> pumps) throws IOException {
        List<HydraulicCharacteristics> hydraulicCharacteristicsList = new ArrayList<>();
        for (CirculatingPump pump : pumps) {
            List<HydraulicCharacteristics> list = pump.characteristics;
            hydraulicCharacteristicsList.addAll(list);
        }
        objectMapper.writeValue(file, hydraulicCharacteristicsList);
    }

    public void getJsonReport(File file) throws IOException {
        List<HydraulicCharacteristics> characteristics = objectMapper.readValue(file, new TypeReference<List<HydraulicCharacteristics>>() {
        });
        List<CirculatingPump> list = new ArrayList();
        for (CirculatingPump pump : listOfPumps) {
            List<HydraulicCharacteristics> pumpHydraulicCharacteristics = pump.characteristics;
            for (HydraulicCharacteristics characteristic : characteristics) {
                for (HydraulicCharacteristics pumpHydraulicCharacteristic : pumpHydraulicCharacteristics) {
                    if (characteristic.capacity == pumpHydraulicCharacteristic.capacity &&
                            characteristic.pressure == pumpHydraulicCharacteristic.pressure) {
                        list.add(pump);
                    }
                }
            }
        }
    }

}



