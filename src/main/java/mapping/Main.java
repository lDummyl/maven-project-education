package mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Pump pump = new Pump(Optional.of(1), Optional.of(5));
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(pump);
        System.out.println(s);
        PumpDto pumpDto = objectMapper.convertValue(pump, PumpDto.class);
        System.out.println(pumpDto);
    }
}
