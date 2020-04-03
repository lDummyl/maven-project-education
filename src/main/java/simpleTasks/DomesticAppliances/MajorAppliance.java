package simpleTasks.DomesticAppliances;

public class MajorAppliance extends DomesticAppliance {

    public MajorAppliance(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost pay() {
        return null;
    }
}
