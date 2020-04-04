package simpleTasks.DomesticAppliances;

public class MicrowaveOven extends DomesticAppliance {
    public MicrowaveOven(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost consumeElectricity() {
        return null;
    }
}
