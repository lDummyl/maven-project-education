package task7.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Pump {

    UUID id;
    String model;
    Double price;
    Double flow;
    Double pressure;
}
