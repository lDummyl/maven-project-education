package task7;

import java.util.List;
import java.util.Objects;

public class CirculatingPump {
    String vendorCode;
    Double price;
    List <HydraulicCharacteristics> characteristics;

    public CirculatingPump() {
    }

    public CirculatingPump(String vendorCode, List <HydraulicCharacteristics> characteristics, Double price) {
        this.vendorCode = vendorCode;
        this.characteristics = characteristics;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CirculatingPump{" +
                "vendorCode='" + vendorCode + '\'' +
                ", price=" + price +
                ", characteristics=" + characteristics +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public List<HydraulicCharacteristics> getCharacteristics() {
        return characteristics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CirculatingPump that = (CirculatingPump) o;
        return Objects.equals(vendorCode, that.vendorCode) && Objects.equals(price, that.price) && Objects.equals(characteristics, that.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorCode, price, characteristics);
    }
}
