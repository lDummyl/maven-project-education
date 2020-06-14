package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;


public class BusinessCenter {
    PersonProvider personProvider = new PersonProvider();

    public Office createOffice(int requireOfSecretary, int requireOfSecurity, int requireOfJurist,
                               int requireOfAccountant, List<? extends OfficeWorker> allCandidates){
        // TODO: 6/14/20 во первых зачем этот класс? если все равно все пихается в конструктор?
        //  сделай дефолтные значения полей, которые н меняются в текущем контексте.
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requireOfSecretary,
                requireOfSecurity, requireOfJurist, requireOfAccountant, allCandidates);
    }

}
