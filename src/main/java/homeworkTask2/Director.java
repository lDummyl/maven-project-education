package homeworkTask2;

import java.util.*;

public class Director extends Person {
    int enoughCandidatesToDecide;

    public Director(Person person, int enoughCandidatesToDecide) {
        super(person.name, person.age);
        this.enoughCandidatesToDecide = enoughCandidatesToDecide;
    }

    public <T extends Person> Object select(HashMap<Class<?>, List> candidates, Class <?> position) {
        List list1 = candidates.get(position);
            if (list1.size() >= enoughCandidatesToDecide) {
                Random random = new Random();
                return list1.get(random.nextInt(list1.size()));
        }
            return null;
    }
}
