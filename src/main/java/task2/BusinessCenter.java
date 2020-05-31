package task2;

import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;

public class BusinessCenter {

    public List<Office> createOffice(int qty){
        PersonProvider personProvider = new PersonProvider();
        List<Office> offices = new ArrayList<>();
        for (int i = 0; i < qty; i++){
            offices.add(new Office(personProvider.getSomeDirector(), personProvider.getSomeHr()));
        }
        return offices;
    }

}
