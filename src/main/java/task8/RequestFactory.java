package task8;

import com.fasterxml.jackson.databind.ObjectMapper;
import task7.HydraulicCharacteristics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RequestFactory {
    ObjectMapper objectMapper = new ObjectMapper();

    public List <Request> getRequestsList (int qty){
        List <Request> requestsList = new ArrayList<>();
        while (qty > 0)
        {
            requestsList.add(new Request(getDate(), getHydraulicCharacteristics()));
            qty--;
        }
        return requestsList;
    }

    public void getRequestListInJSON (File file, List list) throws IOException {
        objectMapper.writeValue(file, list);
    }

    private HydraulicCharacteristics getHydraulicCharacteristics() {
        float maxPressure = 10.0f;
        float maxCapacity = 15.0f;
        float pressure = new Random().nextFloat() * maxPressure;
        float capacity = new Random().nextFloat() * maxCapacity;
        return new HydraulicCharacteristics(pressure, capacity);
    }

    private LocalDate getDate() {
        int days = 365;
        return LocalDate.now().minusDays(new Random().nextInt(days));
    }

}
