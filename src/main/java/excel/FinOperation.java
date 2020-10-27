package excel;

import org.apache.poi.ss.usermodel.Cell;

import java.time.LocalDate;

public class FinOperation {
    LocalDate date;
    Double sum;
    String payer;

    public FinOperation(Cell rawDate, Cell avoir, Cell description) {
        date = parseDate(rawDate);
        sum = parseSum(avoir);
        payer = parseDescr(description);
    }

    private String parseDescr(Cell description) {
        return null;
    }

    private Double parseSum(Cell avoir) {
        return null;
    }

    private LocalDate parseDate(Cell rawDate) {
        return null;
    }
}
