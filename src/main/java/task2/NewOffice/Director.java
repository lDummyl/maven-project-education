package task2.NewOffice;

import task1.Person;

import java.util.*;

public class Director extends Person {

    String name;
    Hr hr;
    // TODO: 6/13/20 лишнее поле
    Secretary secretary;
    Office office;

    public Director(String name, Office office) {
        super(null, null);
        this.name = name;
        this.office = office;
    }

    public final int enoughForDecision = 4;


    public ApplyingForAJob chooseSecretary(Set<ApplyingForAJob> set) throws BadWorkException {
        List<ApplyingForAJob> list = new ArrayList<>();
        list.addAll(set);
        if (list.size() < enoughForDecision) {
            return null;
        }
        ApplyingForAJob candidate = list.get(new Random().nextInt(list.size()));
        if (candidate instanceof Secretary) {
            return (Secretary) candidate;
        } else {
            throw new BadWorkException("Bad Work " + hr.name);
        }
    }


}
