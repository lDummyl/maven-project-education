package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;


public class BusinessCenter {
    PersonProvider personProvider = new PersonProvider();

    public Office createOffice(int requireOfAccountant){
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requireOfAccountant);
    }

    public Office createOfficeCand(int requireOfAccountant) throws Exception {
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requireOfAccountant, personProvider.getSomeAllCandidates(30));
    }

    public Office createOffice(){
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr());
    }

    public List<Office> createOffices(int ...requireOfAccountant) throws Exception {
        List<Office> officeList = new ArrayList<>();
        for(int i = 0; i < requireOfAccountant.length; i++){
            officeList.add(createOffice(requireOfAccountant[i]));
        }
        return officeList;
    }

    public List<Office> createOfficesCand(int ...requireOfAccountant) throws Exception {
        List<Office> officeList = new ArrayList<>();
        for(int i = 0; i < requireOfAccountant.length; i++){
            officeList.add(createOfficeCand(requireOfAccountant[i]));
        }
        return officeList;
    }
}


