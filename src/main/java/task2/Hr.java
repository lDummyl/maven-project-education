package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hr {

    Random random = new Random();
    final int sizeOfListHr;

    {
        sizeOfListHr = random.nextInt(new Secretary(null, null).getPersons().size());
    }

    public List<Person> chooseSecretary() {
        List<Person> choosen = new ArrayList();
        for (int i = 0; i < new Secretary(null, null).getPersons().size(); i++) {
            choosen.add(new Secretary(null,null).getPersons().get(i));
            if (choosen.size() == sizeOfListHr) {
                break;

            }
        }
        return choosen;
    }


}
