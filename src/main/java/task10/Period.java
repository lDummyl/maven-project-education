package task10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Period {

    private LocalDate start;
    private LocalDate end;

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
