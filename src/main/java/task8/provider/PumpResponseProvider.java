package task8.provider;

import task7.selector.PumpSelectorException;
import task7.pump.Pump;
import task7.pump.Speed;
import task8.report.PumpResponse;
import task8.PumpWorkPoint;
import task8.PumpRequest;

import java.util.Optional;

public class PumpResponseProvider {

    public PumpResponse createPumpResponse(Optional<Pump> pump, PumpRequest request) {
        if (pump.isPresent()) {
            return createPumpSuccessResponse(pump, request);
        } else {
            return emptyPumpResponse(pump, request);
        }
    }

    private PumpResponse emptyPumpResponse(Optional<Pump> pump, PumpRequest request) {
        PumpResponse response = new PumpResponse();
        response.setPump(pump);
        response.setRequest(request);
        return response;
    }

    private PumpResponse createPumpSuccessResponse(Optional<Pump> pump, PumpRequest request) {
        PumpResponse response = new PumpResponse();

        response.setPump(pump);
        response.setModel(pump.get().getModel());
        response.setRequest(request);
        response.setWorkPoint(workPointSearch(pump.get(), request));

        return response;
    }

    public PumpResponse createPumpResponse(PumpSelectorException e, PumpRequest request) {
        PumpResponse response = new PumpResponse();
        response.setError(e);
        response.setRequest(request);

        return response;
    }

    private PumpWorkPoint workPointSearch(Pump pump, PumpRequest request) {

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
        return new PumpWorkPoint(consumptionValue, request.getPressure());
    }
}
