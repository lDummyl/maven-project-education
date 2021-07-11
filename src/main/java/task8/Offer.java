package task8;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import task7.CirculatingPump;

import java.time.LocalDate;

public class Offer {

    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)

    LocalDate date;
    CirculatingPump pump;
    String comment;

    public Offer() {
    }

    public Offer(LocalDate date, CirculatingPump pump, String comment) {
        this.date = date;
        this.pump = pump;
        this.comment = comment;
    }

    public Offer(LocalDate date, CirculatingPump pump) {
        this.date = date;
        this.pump = pump;
    }

    public LocalDate getDate() {
        return date;
    }

    public CirculatingPump getPump() {
        return pump;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "date=" + date +
                ", pump=" + pump +
                ", comment='" + comment + '\'' +
                '}';
    }
}
