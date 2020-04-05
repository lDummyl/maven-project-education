package simpleTasks.DomesticAppliances.MyVersion;

public class PowerConsumption {
    private final double electricityCost;

    public PowerConsumption(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    @Override
    public String toString() {
        return "You consume " + electricityCost + " kw electricity per day ";
    }
}
