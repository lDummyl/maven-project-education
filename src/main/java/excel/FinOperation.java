package excel;

import org.apache.poi.ss.usermodel.Cell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FinOperation {
    LocalDate date;
    String payer;
    Double moneyReceipt;
    Double consumption;
    String description;

    public FinOperation(Cell rawDate, Cell payer, Cell receipt, Cell consumption, Cell description) {
        this.date = parseDate(rawDate);
        this.payer = parseStr(payer);
        this.moneyReceipt = parseDouble(receipt);
        this.consumption = parseDouble(consumption);
        this.description = parseStr(description);
    }

    private LocalDate parseDate(Cell rawDate) {
        String date = rawDate.getStringCellValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    private String parseStr(Cell payer)
    {
        return String.valueOf(payer);
    }
    private double parseDouble(Cell moneyReceipt) {
        String s = moneyReceipt.getStringCellValue();
        s = s.replace(" ", "");
        if (s.equals("")) {
            return 0.00;
        }
            return Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return "FinOperation{" +
                "date=" + date +
                ", payer='" + payer + '\'' +
                ", moneyReceipt=" + moneyReceipt +
                ", consumption=" + consumption +
                ", description='" + description + '\'' +
                '}';
    }


}
