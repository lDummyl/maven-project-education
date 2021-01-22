package newpumpbutchselector;

import newpumpselector.CirculationPumpSelectorException;
import task7.Pump;
import task7.Speed;
import task8.PumpRequest;

import java.util.Optional;

public class PumpResponseProvider {

    public CirculationPumpResponse createPumpResponse(Optional<Pump> pump, PumpRequest request) {
        if (pump.isPresent()) {
            return createPumpSuccessResponse(pump, request);
        } else {
            return emptyPumpResponse(pump, request);
        }
    }

    private CirculationPumpResponse emptyPumpResponse(Optional<Pump> pump, PumpRequest request) {
        CirculationPumpResponse response = new CirculationPumpResponse();
        response.setPump(pump);
        response.setRequest(request);
        return response;
    }

    private CirculationPumpResponse createPumpSuccessResponse(Optional<Pump> pump, PumpRequest request) {
        CirculationPumpResponse response = new CirculationPumpResponse();

        response.setPump(pump);
        response.setModel(pump.get().getModel());
        response.setRequest(request);
        response.setWorkPoint(workPointSearch(pump.get(), request));

        return response;
    }

    public CirculationPumpResponse createPumpResponse(CirculationPumpSelectorException e, PumpRequest request) {
        CirculationPumpResponse response = new CirculationPumpResponse();
        response.setError(e);
        response.setRequest(request);

        return response;
    }

    private CirculationPumpWorkPoint workPointSearch(Pump pump, PumpRequest request) {

        Speed workSpeed = null;
        for (Speed speed : pump.getSpeeds()) {
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
