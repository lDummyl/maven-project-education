package simpleTasks.DomesticAppliances;

public class Refrigerator extends DomesticAppliance {

    public Refrigerator(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost consumeElectricity() {
       if(madeBy.equals("Samsung")){
           return new ElectricityCost(0.84, this);  //потребление 0.84 кВт за сутки
       }
       return new ElectricityCost(0.6, this);
    }
}
