package task2;

import org.w3c.dom.ls.LSInput;
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

    public void sort(Object object) {
        if (object instanceof Secretary) {
            approvedSecretary.add((Secretary) object);
        } else if (object instanceof Security) {
            approvedSecurity.add((Security) object);
        } else if (object instanceof Jurist) {
            approvedJurist.add((Jurist) object);
        } else if (object instanceof Accountant) {
            approvedAccountant.add((Accountant) object);
        }
    }


    public void filter(List<? extends OfficeWorker> officeWorkers) {
        for (OfficeWorker officeWorker : officeWorkers) {
            if (passedInterwiew(officeWorker)) {
                sort(officeWorker);
            }
        }
    }

    private boolean passedInterwiew(OfficeWorker officeWorker) {
        return officeWorker.getPerson().getAge().getYear() < YEAR_OF_BIRTH &&
                officeWorker.passInterview();
    }

    @Override
    public String toString() {
        return "Hr{" +
                person +
                '}';
    }

    public void invite(Object human) {
        if (human instanceof OfficeWorker && passedInterwiew((OfficeWorker) human)) {
            sort(human);
        } else {
            System.out.println("Bye!");
        }
    }
}
