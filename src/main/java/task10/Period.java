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
        int startYear = start.getYear();
        int startMonth = start.getMonthValue();
        int endYear = end.getYear();
        int endMonth = end.getMonthValue();
        int month = (endYear * 12 + endMonth) - (startYear * 12 + startMonth) + 1;
        return month;
        //return java.time.Period.between(start, end).getMonths();
    }
}
