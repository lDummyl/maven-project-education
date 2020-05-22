package task2;

import java.util.ArrayList;
import java.util.List;

// TODO: 5/21/20 все эти классы в отдельные фаилы, это легко сделать добавив модификатор public и через alt+Enter
public class Secretary extends Person {

    public Secretary(Name name, BirthDate age) {
        super(name, age);
    }

    // TODO: 5/21/20 подобные статические методы это не очень хорошо.
    public List<Person> getPersons() {
        List<Person> secretaries;
        secretaries = new ArrayList<>();
        for (int i = 0; i < Name.getNames().size(); i++) {
            secretaries.add(new Person(Name.getNames().get(i), BirthDate.getBirthDates().get(i)));
        }
        return secretaries;
    }
}
