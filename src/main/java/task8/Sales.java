package task8;
import task7.Calculation;
import task7.CirculatingPump;
import java.util.List;

public class Sales {
    Calculation calculation = new Calculation();

    private double getPriceInDollars(CirculatingPump pump) {
        double exchangeRate = 74.63;
        return pump.getPrice() / exchangeRate;
    }

    public CirculatingPump getAlternativePump(List<CirculatingPump> list)  {
        List<CirculatingPump> list1 = calculation.listOfPumps;
        for (CirculatingPump pump : list1) {
            double price = getMiddleSum(list);
            if (price < pump.getPrice())
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
    public double deliveryCost(List<Offer> list) {
        double sum = 0;
        double amountWithoutAccDelivery = 10000.00;
        double extraChargeForDelivery = 0.1;
        for (Offer offer : list) {
            double priceInDollars = getPriceInDollars(offer.getPump());
            sum = sum + priceInDollars;
        }
            if (sum > amountWithoutAccDelivery) {
                sum = 0;
            }
            else
                sum = sum * extraChargeForDelivery;

        return sum;
    }

}
