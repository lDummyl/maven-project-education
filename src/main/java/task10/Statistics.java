package task10;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task8.Offer;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    ObjectMapper mapper = new ObjectMapper();
    public List<Offer> readOffers (File file) throws IOException {
        return mapper.readValue(file, new TypeReference<List<Offer>>(){});
    }

    public Map<Month, Integer> qtyPurchasesPerMonth(List <Offer> list){
        HashMap <Month, Integer> purchasesPerMonth = new HashMap<>();
        for (Offer offer : list) {
            Month month = offer.getDate().getMonth();
            purchasesPerMonth.merge(month, 1, Integer::sum);
        }
        return purchasesPerMonth;
    }

    public Map<Integer, Integer> qtyPurchasesPerYear(List <Offer> list){
        HashMap <Integer, Integer> purchasesPerYear = new HashMap<>();
        for (Offer offer : list) {
            Integer year = offer.getDate().getYear();
            purchasesPerYear.merge(year, 1, Integer::sum);
        }
        return purchasesPerYear;
    }

    public int getMiddleQtyPurchasesPerMonth(List <Offer> list){
        int qtyMonths = 12;
        int purchases = 0;
        for (Offer offer : list) {
            if (offer.getPump() != null)
             purchases++;
        }
        return purchases / qtyMonths;
    }

    public Map<Month, Integer> qtyErrorsPerMonth(List <Offer> list){
        HashMap <Month, Integer> purchasesPerMonth = new HashMap<>();
        for (Offer offer : list) {
            Month month = offer.getDate().getMonth();
            if (offer.getComment() != null) {
                purchasesPerMonth.merge(month, 1, Integer::sum);
            }
        }
        return purchasesPerMonth;
    }

}
