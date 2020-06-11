package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;


public class BusinessCenter {
    PersonProvider personProvider = new PersonProvider();

    public Office createOffice(){
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr());
    }

    public List<Office> createOffice(int qtyOffices){
        List<Office> officeList = new ArrayList<>();
        for (int i = 0; i < qtyOffices; i++){
            officeList.add(new Office(personProvider.getSomeDirector(), personProvider.getSomeHr()));
        }
        return officeList;
    }
}
