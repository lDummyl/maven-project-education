package simpleTasks.DomesticAppliances;

public class WashingMachine extends DomesticAppliance {
    public WashingMachine(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost consumeElectricity() {
        return null;
    }
}
