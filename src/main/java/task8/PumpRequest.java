package task8;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
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
}
