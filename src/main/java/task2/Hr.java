package task2;

import task1.Person;

import java.util.*;

public class Hr extends OfficeWorker {

    Person person;
    List<OfficeWorker> approved = new ArrayList<>();
    Map<Class<?>, Collection<OfficeWorker>> stuff = new HashMap<>();


    public static final int YEAR_OF_BIRTH = 2000;


    public Hr(Person person) {
        this.person = person;
    }

    public <T extends OfficeWorker> List<T> filter(List<T> officeWorkers) {
//        Collection<OfficeWorker> officeWorkers1 = stuff.get(Security.class);
        List<T> approved = new ArrayList<>();
        for (int i = 0; i < officeWorkers.size(); i++) {

            T t = officeWorkers.get(i);
            if (t.getAge().getYear() < YEAR_OF_BIRTH) {
                approved.add(officeWorkers.get(i));
            }
        }
        return approved;
    }

    public List<OfficeWorker> filterFirst(List<? extends OfficeWorker> people) {
        for (OfficeWorker officeWorker : people) {
            if(officeWorker.passInterview()){
                approved.add(officeWorker);
            }
        }
        return approved;
    }


    @Override
    public String toString() {
        return "Hr{" +
                person +
                '}';
    }
}
