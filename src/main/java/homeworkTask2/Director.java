package homeworkTask2;

import java.util.List;
import java.util.Random;

public class Director extends Person{
int enoughCandidatesToDecide;

    public Director(Person person, int enoughCandidatesToDecide) {
        super(person.name, person.age);
        this.enoughCandidatesToDecide = enoughCandidatesToDecide;
    }

    public Secretary select (List <Secretary> list)
    {
        if (list.size() < enoughCandidatesToDecide)
        { return null; }
        else
        {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }

}
