package task2;

import task2.Skills.CanPassInterview;

import java.util.ArrayList;
import java.util.List;

public class Hr {
    private Office office;
    private ArrayList <Person> candidates = new ArrayList<>();

    public List<Person> examinePerson(Person person) {
        if (office.getSecretary() != null) {
            System.out.println("В офисе уже есть секретарь - " + office.getSecretary().getName());
            candidates.clear();
            return candidates;
        }
        if (person instanceof CanPassInterview) // TODO: 11/3/19 не самый лучший способ использования интерфейсов
            candidates.add(person);
        return candidates;
    }
    protected void setOffice(Office office) {
        this.office = office;
    }
}
