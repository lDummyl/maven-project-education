package task7;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task6.LagrangePolynomial;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class PumpCollector {
    private File jsonFile;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public PumpCollector(File jsonSerialize) {
        if (jsonSerialize.exists()) {
            this.jsonFile = jsonSerialize;
        } else {
            this.jsonFile = new File(jsonSerialize.getPath());
        }
    }

    // TODO: 12/17/2020 Потенциальная проблема
    public PumpCollector() {
        if (!this.jsonFile.exists()) {
            this.jsonFile = new File("Pumps.json");
        }
    }

    public void addToJson(Pump pump) {
        try {
           /* Set<Pump> pumps = objectMapper.readValue(this.jsonFile, new TypeReference<Set<Pump>>() {
            });
            pumps.add(pump);*/
            objectMapper.writeValue(this.jsonFile, pump);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Adding pump error");
        }
    }

    public Pump selectPump(Collection<Pump> pumps, Double consumption, Double pressure) {
        ArrayList<Pump> pumpsList = new ArrayList<>(pumps);
        HashMap<Pump, Double> resultPumpMap = new HashMap<>();
        for (Pump pump : pumpsList) {
            List<Pump.Speed> speeds = pump.getSpeeds();
            for (Pump.Speed s : speeds) {
                LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(s.getConsumption(), s.getPressure());
                double current = lagrangePolynomial.lagrangePolynomial(consumption);
                resultPumpMap.put(pump, Math.abs(pressure - current));
            }

        }

        return null;
    }
}
