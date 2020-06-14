package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;


public class BusinessCenter {
    PersonProvider personProvider = new PersonProvider();

    public Office createOffice(int requireOfSecretary, int requireOfSecurity, int requireOfJurist,
                               int requireOfAccountant, List<? extends OfficeWorker> allCandidates){
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requireOfSecretary,
                requireOfSecurity, requireOfJurist, requireOfAccountant, allCandidates);
    }

}
