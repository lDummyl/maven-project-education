package task8;

// насос, входные параметры,рабочая точка модель, первый технический блок

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import task7.Pump;
import task7.PumpSelector;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@JsonAutoDetect
public class PumpTechnicalBlock {
    private Pump pump;
    private String model;
    private PumpRequest request;
    private WorkPoint workPoint;


    public PumpTechnicalBlock(PumpRequest request, List<Pump> pumpsList) {
        this.request = request;
        this.pump = selectPump(request, pumpsList);
        this.model = pump.getModel();
        this.workPoint = new WorkPoint(this.pump, request.getConsumption(), request.getPressure());
    }

    private Pump selectPump(PumpRequest request, Collection<Pump> pumps) {
        PumpSelector pumpSelector = new PumpSelector();
        Optional<Pump> pumpOptional = pumpSelector.selectPump(pumps, request.getConsumption(), request.getPressure());
        if (pumpOptional.isPresent()) {
            return pumpOptional.get();
        } else {
            throw new IllegalStateException("There is no needed pump");
        }
    }

    public PumpTechnicalBlock() {
    }

    public Pump getPump() {
        return pump;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
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
    private class WorkPoint {
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
