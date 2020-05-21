package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hr {

    Random random = new Random();
    final int sizeOfListHr;

    {
        sizeOfListHr = random.nextInt(Secretary.getPersons().size());
    }

    public List<Person> chooseSecretary() {
        List<Person> choosen = new ArrayList();
        for (int i = 0; i < Secretary.getPersons().size(); i++) {
            choosen.add(Secretary.getPersons().get(i));
            if (choosen.size() == sizeOfListHr) {
                break;
            }
        }
        return choosen;
    }


}
