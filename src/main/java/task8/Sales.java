package task8;
import task7.Calculation;
import task7.CirculatingPump;

import java.util.ArrayList;
import java.util.List;

public class Sales {
    Calculation calculation = new Calculation();

    private double getPriceInDollars(CirculatingPump pump) {
        double exchangeRate = 74.63;
        return pump.getPrice() / exchangeRate;
    }

    // по поводу этого метода совсем не уверена. Нужно добавлять по 1 насосу на каждую ошибку?
    public List <CirculatingPump> addAlternativePumps(List<CirculatingPump> list) {
        List <Object> listOfErrValues = calculation.listOfErrValues;
        List<CirculatingPump> additionalPumps = new ArrayList<>();
        if (!listOfErrValues.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                additionalPumps.add(getAlternativePump(list));
            }
        }
        return additionalPumps;
    }

    private CirculatingPump getAlternativePump(List<CirculatingPump> list)  {
        List<CirculatingPump> list1 = calculation.listOfPumps;
        for (CirculatingPump pump : list1) {
            double price = getMiddleSum(list);
            if (price < pump.price)
                return pump;
        }
        return null;
    }

    public double getMiddleSum(List<CirculatingPump> list) {
        double sum = 0;
        for (CirculatingPump pump : list) {
            sum = sum + pump.getPrice();
        }
        return sum / list.size();
    }

    public double getTotalSum(List<CirculatingPump> list) {
        double sum = 0;
        double amountWithoutAccDelivery = 10000.00;
        double extraChargeForDelivery = 0.1;
        for (CirculatingPump pump : list) {
            double priceInDollars = getPriceInDollars(pump);
            sum = sum + priceInDollars;
            if (sum < amountWithoutAccDelivery) {
                sum = sum + sum * extraChargeForDelivery;
            }
        }
        return sum;
    }

}
