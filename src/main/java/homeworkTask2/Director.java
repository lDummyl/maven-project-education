package homeworkTask2;

import java.util.*;

public class Director extends Person {
    int enoughCandidatesToDecide;

    public Director(Person person, int enoughCandidatesToDecide) {
        super(person.name, person.age);
        this.enoughCandidatesToDecide = enoughCandidatesToDecide;
    }

    public <T extends Person> Person select(HashMap<Class<?>, List> map) {
        for (Map.Entry<Class<?>, List> entry : map.entrySet()) {
            if (entry.getValue().size() < enoughCandidatesToDecide) {
                return null;
            } else {
                Random random = new Random();
                List list = entry.getValue();
                return (Person) list.get(random.nextInt(map.values().size()));
            }
        }
        return null;
    }
}
