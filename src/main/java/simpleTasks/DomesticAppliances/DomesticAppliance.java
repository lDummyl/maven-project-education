package simpleTasks.DomesticAppliances;

public abstract class DomesticAppliance {
    double price;
    String madeBy;
    double electricityCost;  // затраты на электричество за сутки

    public DomesticAppliance(String madeBy) {
        this.madeBy = madeBy;
    }

    public abstract ElectricityCost pay();
}
