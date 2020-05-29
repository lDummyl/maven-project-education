package task1;

import task2.Secretary;

import java.time.LocalDate;
import java.util.*;

public class PersonProvider {
    List<String> listOfFirstNames = Arrays.asList("Ella", "Harry", "Artur", "Kevin", "Kate", "Michael", "David", "Nick");
    List<String> listOFLastNames = Arrays.asList("Brown", "Harrison", "Stevenson", "Gibson", "Smith", "Davidson", "Nixon");

    public Person getPeople()
    {
        Random random = new Random();
        Name name = new Name(listOfFirstNames.get(random.nextInt(listOfFirstNames.size())), listOFLastNames.get(random.nextInt(listOFLastNames.size())));
        Age age = randomDate();
        return new Person(name, age);
    }


    public static int difference(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return i + min;
    }

    public Age randomDate()
    {
        int year = difference(1960, 2000);
        int month = difference(1, 12);
        int day =0;
        switch (month) {
            case 2:
                if (year % 4 == 0) {
                    day = difference(1, 29);
                } else {
                    day = difference(1, 28);
                }
            break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = difference(1, 30);
                break;
            default:
                day = difference(1, 31);
                break;
            }
        return new Age(year, month, day);
    }



    public List<Secretary> getSecretaries(int i) {
        ArrayList<Secretary> secretaries = new ArrayList<>();
        while (secretaries.size() != i) {
            secretaries.add(new Secretary(getPeople().name, getPeople().age));
        }
        return secretaries;
    }
}
