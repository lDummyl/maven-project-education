package newpumpbutchselector;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task8.PumpRequest;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
public class CirculationPumpResponse {
    private Optional<Pump> pump;
    private String model;
    private PumpRequest request;
    private CirculationPumpSelectorException error;
    private CirculationPumpWorkPoint workPoint;
}

