package task7;

import task6.LagrangePolynomial;

public class CirculationPump implements Pump {

    private final int MIN_CONSUMPTION = 5;
    private final int MAX_CONSUMPTION = 40;
    private final double MIN_POWER = 3d;
    private final double MAX_POWER = 24d;

    private int consumption;
    private double power;
    private double avail;

    public CirculationPump() {
        consumption = MIN_CONSUMPTION;
        power = MIN_POWER;
    }

    public CirculationPump(int consumption, double power) {
        setConsumption(consumption);
        setPower(power);
    }

    @Override
    public Double calculateConsumption(Double flow) {
        return 0d; //LagrangePolynomial.getLagrangePolynomial(consumption, power);
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        if (consumption >= MIN_CONSUMPTION && consumption <= MAX_CONSUMPTION) {
            this.consumption = consumption;
        } else if (this.consumption == 0) {
            this.consumption = MIN_CONSUMPTION;
        }
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power >= MIN_POWER && power <= MAX_POWER) {
            this.power = power;
        } else if (this.power == 0d) {
            this.power = MIN_POWER;
        }
    }
}
