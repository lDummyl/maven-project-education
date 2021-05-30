package task8;

import task7.HydraulicCharacteristics;
import java.time.LocalDate;

public class Request {
    LocalDate date;
    HydraulicCharacteristics characteristics;

    public Request(LocalDate date, HydraulicCharacteristics characteristics) {
        this.date = date;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Request{" +
                "date=" + date +
                ", characteristics=" + characteristics +
                '}';
    }
}
