package task8;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import task7.HydraulicCharacteristics;

import java.time.LocalDate;


public class Request {
    public Request() {
    }

    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)

    LocalDate date;
    HydraulicCharacteristics characteristics;

    public Request(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public HydraulicCharacteristics getCharacteristics() {
        return characteristics;
    }

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

