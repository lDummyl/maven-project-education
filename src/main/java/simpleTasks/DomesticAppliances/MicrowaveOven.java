package simpleTasks.DomesticAppliances;

public class MicrowaveOven extends MajorAppliance {
    public MicrowaveOven(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost pay() {
        return null;
    }
}
