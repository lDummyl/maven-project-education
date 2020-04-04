package simpleTasks.DomesticAppliances;

public abstract class DomesticAppliance { // TODO: 4/4/20 газовая плита тоже бытовая техника
    double price;
    String madeBy;
    double electricityCost;  // затраты на электричество за сутки

    public DomesticAppliance(String madeBy) {
        this.madeBy = madeBy;
    }

    public abstract ElectricityCost pay(); // TODO: 4/4/20 вещи сами не платят за электричество, они могут его потреблять, сообщать потребленное кол-во

}
