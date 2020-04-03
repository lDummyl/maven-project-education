package simpleTasks.DomesticAppliances;

public class WashingMachine extends MajorAppliance {
    public WashingMachine(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost pay() {
        return null;
    }
}
