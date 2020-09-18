package task7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pump {

    UUID id;
    String model;
    Double price;
    Double flow;
    Double pressure;
}
