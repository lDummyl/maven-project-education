package task2;

import task1.Person;

import java.util.*;

public class Hr extends OfficeWorker {

    Person person;
    List<Secretary> approvedSecretary = new ArrayList<>();
    List<Security> approvedSecurity = new ArrayList<>();
    List<Jurist> approvedJurist = new ArrayList<>();
    List<Accountant> approvedAccountant = new ArrayList<>();

    public static final int YEAR_OF_BIRTH = 2000;


    public Hr(Person person) {
        this.person = person;
    }

    public void sort(Object object){
        if(object instanceof Secretary){
            approvedSecretary.add((Secretary) object);
        }else if (object instanceof Security){
            approvedSecurity.add((Security) object);
        }else if (object instanceof Jurist){
            approvedJurist.add((Jurist) object);
        }else if (object instanceof Accountant){
            approvedAccountant.add((Accountant) object);
        }
    }

    public void filter(List<? extends OfficeWorker> officeWorkers) {
        for (int i = 0; i < officeWorkers.size(); i++) {
            if (officeWorkers.get(i).getPerson().getAge().getYear() < YEAR_OF_BIRTH &&
                    officeWorkers.get(i).passInterview()) {
                sort(officeWorkers.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Hr{" +
                person +
                '}';
    }
}
