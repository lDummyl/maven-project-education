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

    public CirculationPumpResponse(Pump pump, PumpRequest request) {
        this.request = request;
        this.pump = Optional.of(pump);
        this.model = pump.getModel();
        this.workPoint = workPointSearch();
    }

    public CirculationPumpResponse(PumpRequest request) {
        this.request = request;
    }

    public CirculationPumpResponse(CirculationPumpSelectorException e) {
        this.error = e;
    }

    private CirculationPumpWorkPoint workPointSearch() {

        Pump.Speed workSpeed = null;
        for (Pump.Speed speed : pump.get().getSpeeds()) {
            Double pressureValue = speed.getPressureValue(request.getConsumption());
            if (pressureValue >= request.getPressure()) {
                workSpeed = speed;
                break;
            }
        }
        assert workSpeed != null;
        Double consumptionValue = workSpeed.getConsumptionValue(request.getPressure());
        return new CirculationPumpWorkPoint(consumptionValue, request.getPressure());
    }

}

