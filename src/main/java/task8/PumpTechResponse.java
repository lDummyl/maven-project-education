package task8;

// насос, входные параметры,рабочая точка модель, первый технический блок

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task7.Pump;
import task7.PumpSelector;

import java.util.Optional;

@JsonAutoDetect
public class PumpTechResponse {
    private Pump pumpOrNull;
    private String model;
    private PumpRequest request;
    private WorkPoint workPoint;


    public PumpTechResponse(PumpRequest request, Optional<Pump> pumpOrNull) {
        defineAvailabilityOfPump(pumpOrNull, request);
        this.request = request;
    }

    private void defineAvailabilityOfPump(Optional<Pump> pump, PumpRequest request) {
        if (pump.isPresent()) {
            presetPump(pump.get(), request);
        } else {
            presetNoPump();
        }
    }

    private void presetNoPump() {
        this.model = "none";
        this.pumpOrNull = null;
        this.workPoint = null;
    }

    private void presetPump(Pump pump, PumpRequest request) {
        this.pumpOrNull = pump;
        this.model = pump.getModel();
        this.workPoint = new WorkPoint(this.pumpOrNull, request.getConsumption(), request.getPressure());
    }


    public PumpTechResponse() {
    }

    public Pump getPumpOrNull() {
        return pumpOrNull;
    }

    public void setPumpOrNull(Pump pumpOrNull) {
        this.pumpOrNull = pumpOrNull;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public PumpRequest getRequest() {
        return request;
    }

    public void setRequest(PumpRequest request) {
        this.request = request;
    }

    public WorkPoint getWorkPoint() {
        return workPoint;
    }

    public void setWorkPoint(WorkPoint workPoint) {
        this.workPoint = workPoint;
    }

    @JsonAutoDetect
    private static class WorkPoint {
        Double consumption;
        Double pressure;

        public WorkPoint(Double consumption, Double pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
        }

        public WorkPoint(Pump pump, Double consumption, Double pressure) {
            this.consumption = consumption;
            this.pressure = getPressure(pump, consumption, pressure);
        }

        private Double getPressure(Pump pump, Double consumption, Double pressure) {
            PumpSelector pumpSelector = new PumpSelector();
            Optional<Pump.Speed> workSpeed = pumpSelector.getWorkSpeed(consumption, pressure, pump);
            return workSpeed.map(speed -> speed.getPressureValue(consumption)).orElse(null);
        }

        public WorkPoint() {
        }

        public Double getConsumption() {
            return consumption;
        }

        public void setConsumption(Double consumption) {
            this.consumption = consumption;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }
    }
}
