package task2;

import task1.PersonProvider;


public class BusinessCenter {

    public Office createOffice(int requiredQtyOfSecretary, int requiredQtyOfSecurity,
                               int requiredQtyOfJurist, int requiredQtyOfAccountants){
        PersonProvider personProvider = new PersonProvider();
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requiredQtyOfSecretary,
                requiredQtyOfSecurity, requiredQtyOfJurist, requiredQtyOfAccountants);
    }

    public Office createOffice(int requiredQtyOfAccountants){
        PersonProvider personProvider = new PersonProvider();
        return new Office(personProvider.getSomeDirector(), personProvider.getSomeHr(), requiredQtyOfAccountants);
    }

}
