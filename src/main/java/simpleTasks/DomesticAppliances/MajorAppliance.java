package simpleTasks.DomesticAppliances;

public class MajorAppliance extends DomesticAppliance { // TODO: 4/4/20 этот класс тоже должен быть абстрактным, что он добавляет к Domestic Appl в нем нет ни своих полей ни своих методов странный класс


    public MajorAppliance(String madeBy) {
        super(madeBy);
    }

    @Override
    public ElectricityCost pay() {
        return null;
    }
}
