package task8;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import task6.LagrangePolynomial;
import task7.Pump;


import java.util.ArrayList;
import java.util.Optional;

@JsonAutoDetect
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
        this.model = "none";
        this.pumpOrNull = null;
        this.workPoint = null;
    }

    private void presetPump(Pump pump) {
        this.pumpOrNull = pump;
        this.model = pump.getModel();
        this.workPoint = workPointSearch();
    }

    private WorkPoint workPointSearch() {
        Pump.Speed workSpeed = null;
        for (Pump.Speed speed : pumpOrNull.getSpeeds()) {
            Double pressureValue = speed.getPressureValue(request.getConsumption());
            if (pressureValue >= request.getPressure()) {
                workSpeed = speed;
                break;
            }
        }
        ArrayList<Double> consumptionSystemCurve = new ArrayList<>();
        ArrayList<Double> pressureSystemCurve = new ArrayList<>();

        consumptionSystemCurve.add(0.0);
        pressureSystemCurve.add(0.0);

        consumptionSystemCurve.add(request.getConsumption());
        pressureSystemCurve.add(request.getPressure());

        LagrangePolynomial systemCurve = new LagrangePolynomial(consumptionSystemCurve, pressureSystemCurve);

        Double currentConsumption = request.getConsumption();
        Double pumpCurrentPressure = Double.MAX_VALUE;
        Double systemCurrentPressure = 0.0;


        while ((Math.abs(pumpCurrentPressure - systemCurrentPressure)) > 0.5 ){
            pumpCurrentPressure = workSpeed.getPressureValue(currentConsumption);
            systemCurrentPressure = systemCurve.getValueY(currentConsumption);
            currentConsumption+=0.1;
        }
        return new WorkPoint(currentConsumption, pumpCurrentPressure);
    }


    public PumpTechResponse() {
    }

    public Pump getPumpOrNull() {
        return pumpOrNull;
    }

    public void setPumpOrNull(Pump pumpOrNull) {
        this.pumpOrNull = pumpOrNull;
    }

    @JsonProperty("Модель")
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
