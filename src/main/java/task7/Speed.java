package task7;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task6.LagrangePolynomial;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class Speed {
    private Double[] consumption;
    private Double[] pressure;

    public Speed(Double[] consumption, Double[] pressure) {
        this.consumption = consumption;
        this.pressure = pressure;
    }


    public Double getPressureValue(Double consumption) {
        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(this.consumption, this.pressure);
        Double[] cloneConsumption = getConsumption().clone();
        Arrays.sort(cloneConsumption);
        if (consumption > cloneConsumption[cloneConsumption.length - 1] || consumption < cloneConsumption[0]) {
            return Double.MIN_VALUE;
        } else {
            return lagrangePolynomial.getValueY(consumption);
        }
    }

    public Double getConsumptionValue(Double pressure) {
        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial(this.consumption, this.pressure);
        Double[] clonePressure = getPressure().clone();
        Arrays.sort(clonePressure);
        if (pressure > clonePressure[clonePressure.length - 1] || pressure < clonePressure[0]) {
            return Double.MIN_VALUE;
        } else {
            return lagrangePolynomial.getValueX(pressure);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speed speed = (Speed) o;
        return Arrays.equals(consumption, speed.consumption) && Arrays.equals(pressure, speed.pressure);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(consumption);
        result = 31 * result + Arrays.hashCode(pressure);
        return result;
    }

}
