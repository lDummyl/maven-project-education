package task8;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import task6.LagrangePolynomial;
import task7.Pump;
import task7.Speed;


import java.util.ArrayList;
import java.util.Optional;

@JsonAutoDetect
@Setter
@Getter
public class PumpTechResponse {
    private Pump pumpOrNull;
    private String model;
    private PumpRequest request;
    private WorkPoint workPoint;


    public PumpTechResponse(PumpRequest request, Optional<Pump> pumpOrNull) {
        this.request = request;
        defineAvailabilityOfPump(pumpOrNull, request);
    }

    private void defineAvailabilityOfPump(Optional<Pump> pump, PumpRequest request) {
        if (pump.isPresent()) {
            presetPump(pump.get());
        } else {
            presetNoPump();
        }
    }

    private void presetNoPump() {
        this.pumpOrNull = null;
        this.workPoint = null;
        if (this.request.getPressure() == null || this.request.getConsumption() == null) {
            this.model = "Wrong Request";
        }
        else {
            this.model = "None";
        }
    }

    private void presetPump(Pump pump) {
        this.pumpOrNull = pump;
        this.model = pump.getModel();
        this.workPoint = workPointSearch();
    }

    private WorkPoint workPointSearch() {
        Speed workSpeed = null;
        for (Speed speed : pumpOrNull.getSpeeds()) {
            Double pressureValue = speed.getPressureValue(request.getConsumption());
            if (pressureValue >= request.getPressure()) {
                workSpeed = speed;
                break;
            }
        }
        Double consumptionValue = workSpeed.getConsumptionValue(request.getPressure());
        return new WorkPoint(consumptionValue, request.getPressure());
    }

    @JsonAutoDetect
    public static class WorkPoint {
        Double consumption;
        Double pressure;

        public WorkPoint(Double consumption, Double pressure) {
            this.consumption = consumption;
            this.pressure = pressure;
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
