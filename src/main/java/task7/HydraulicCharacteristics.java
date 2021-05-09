package task7;

public class HydraulicCharacteristics {
    float capacity;
    float pressure;
    int speed;

    public HydraulicCharacteristics(float capacity, float pressure) {
        this.capacity = capacity;
        this.pressure = pressure;
    }

    public HydraulicCharacteristics() {
    }

    public float getCapacity() {
        return capacity;
    }

    public float getPressure() {
        return pressure;
    }

    public HydraulicCharacteristics(float capacity, float pressure, int speed) {
        this.capacity = capacity;
        this.pressure = pressure;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "HydraulicCharacteristics{" +
                "capacity=" + capacity +
                ", pressure=" + pressure +
                ", speed=" + speed +
                '}';
    }
}
