package simpleTasks.DomesticAppliances;

public class ElectricityCost {
    private final double electricityCost;
    private DomesticAppliance appliance;

    public ElectricityCost(double electricityCost, DomesticAppliance appliance) {
        this.electricityCost = electricityCost;
        this.appliance = appliance;
    }

    @Override
    public String toString() {
        return "You'll pay " + + electricityCost +
                " for " + appliance.getClass().getSimpleName() + " per day";
    }
}
