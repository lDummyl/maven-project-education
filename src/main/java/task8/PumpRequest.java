package task8;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class PumpRequest {
    private Double consumption;
    private Double pressure;

    public PumpRequest(Double consumption, Double pressure) {
        this.consumption = consumption;
        this.pressure = pressure;
    }

    public PumpRequest() {
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
