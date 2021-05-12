package task7;

import java.util.List;

public class Sales {

    private double getPriceInDollars(CirculatingPump pump) {
        double exchangeRate = 74.63;
        return pump.getPrice() / exchangeRate;
    }

    public double getTotalSum (List <CirculatingPump> list){
        double sum = 0;
        double amountWithoutAccDelivery = 10000.00;
        double extraChargeForDelivery = 0.1;
        for (CirculatingPump pump : list) {
            double priceInDollars = getPriceInDollars(pump);
            sum = sum + priceInDollars;
            if (sum < amountWithoutAccDelivery){
                sum = sum + sum * extraChargeForDelivery;
            }
        }
        return sum;
    }

}
