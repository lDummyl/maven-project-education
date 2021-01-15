package task8;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonAutoDetect
public class PumpRequest {
    private Double consumption;
    private Double pressure;
    private LocalDate dateTime;

    public PumpRequest(Double consumption, Double pressure) {
        this.consumption = consumption;
        this.pressure = pressure;
        this.dateTime = LocalDate.now();
    }

    public PumpRequest(Double consumption, Double pressure, LocalDate dateTime) {
        this.consumption = consumption;
        this.pressure = pressure;
        this.dateTime = dateTime;
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
}
