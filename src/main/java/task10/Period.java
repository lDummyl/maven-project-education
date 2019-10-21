package task10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Period {

    private LocalDateTime start;
    private LocalDateTime end;

    public int getMonths() {
        java.time.Period between = java.time.Period.between(start.toLocalDate(), end.toLocalDate());
        return (int) between.toTotalMonths() + 1;
    }
}
