package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;


public class BusinessCenter {
    PersonProvider personProvider = new PersonProvider();

    public Office createOffice(int requireOfAccountant, List<? extends OfficeWorker> allCandidates){
        // TODO: 6/14/20 во первых зачем этот класс? если все равно все пихается в конструктор?
        //  сделай дефолтные значения полей, которые н меняются в текущем контексте.
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requireOfAccountant, allCandidates);
    }

    public List<Office> createOffices(int ...requireOfAccountant) throws Exception {
//        List<? extends OfficeWorker> allCandidates = personProvider.getSomeOf(1000, Secretary.class, Security.class,
//                Jurist.class, Accountant.class);

        List<Office> officeList = new ArrayList<>();
        for(int i = 0; i < requireOfAccountant.length; i++){
            officeList.add(createOffice(requireOfAccountant[i], allCandidates));
        }
        return officeList;
    }
}


