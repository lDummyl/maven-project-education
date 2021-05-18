package task7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    ObjectMapper objectMapper = new ObjectMapper();
    public void getJsonFormatFile(File file, List<CirculatingPump> pumps) throws IOException {
        List<HydraulicCharacteristics> hydraulicCharacteristicsList = new ArrayList<>();
        for (CirculatingPump pump : pumps) {
            List<HydraulicCharacteristics> list = pump.characteristics;
            hydraulicCharacteristicsList.add(list.get(0));
        }
        objectMapper.writeValue(file, hydraulicCharacteristicsList);
    }

    public List <CirculatingPump> getJsonReport(File file) throws IOException {
        List<HydraulicCharacteristics> characteristics = objectMapper.readValue(file, new TypeReference<List<HydraulicCharacteristics>>() {
        });
        List<CirculatingPump> list = new ArrayList<>();
        Calculation calculation = new Calculation();
        for (CirculatingPump pump : calculation.listOfPumps) {
            List <HydraulicCharacteristics> hydraulicCharacteristics = pump.characteristics;
            for (HydraulicCharacteristics characteristic : characteristics) {
                for (HydraulicCharacteristics hydraulicCharacteristic : hydraulicCharacteristics) {
                    if (characteristic.capacity == hydraulicCharacteristic.capacity &&
                            characteristic.pressure == hydraulicCharacteristic.pressure) {
                        list.add(pump);
                    }
                }
            }
        }
        return list;
    }
}
