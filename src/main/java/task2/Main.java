package task2;


import task1.Person;
import task1.PersonsProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать 2 офиса Apple и Google и трудоустроить в них секретарей на конкурсной основе, не модифицируя существующий код.
 * Создать 2 имплементации директора и столько же для HR с разным поведеинем, выраженным количественно. все объекты созадются в Main.
 * для создания кандидатов нужно использовать код из 1 й задачи без переноса и копирования, доработка 1 задачи преветствуется.
 */

public class Main {
    Office apple = new Office(new GeneralDirector(),new GeneralHr());
    Office google = new Office(new SecondDirector(),new SecondHr());




    public static void main(String[] args) {
        Office apple = new Office(new GeneralDirector(),new GeneralHr());
        Office google = new Office(new SecondDirector(),new SecondHr());
        PersonsProcessor personsProcessor = new PersonsProcessor();

        ArrayList<Person> people = new ArrayList<>();
        people.addAll(personsProcessor.generatePersons(100));

        apple.invitePeople(people.get(99));

    }

}
