package simpleTasks.DomesticAppliances;

public class Telephone extends DomesticAppliance {

    public Telephone(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost pay() {
        return null;
    }
}
