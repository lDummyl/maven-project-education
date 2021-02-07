package task8.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task7.selector.PumpSelectorException;
import task7.pump.Pump;
import task8.PumpWorkPoint;
import task8.PumpRequest;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
public class PumpResponse {
    private Optional<Pump> pump;
    private String model;
    private PumpRequest request;
    private PumpSelectorException error;
    private PumpWorkPoint workPoint;
}

