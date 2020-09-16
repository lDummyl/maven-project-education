package homeworkTask2;


import java.util.ArrayList;
import java.util.List;

public class SiliconValley {
    public static void main(String[] args) {
        PersonProvider personProvider = new PersonProvider();
        List<Secretary> secretaries = personProvider.getPeople(10);
        Director director = new Director(personProvider.getPerson(), 2);
        Hr hr = new Hr(personProvider.getPerson());
        Office office = new Office(director, hr);
        for (Secretary secretary : secretaries) {
            office.invitePerson(secretary);
        }

        System.out.println(office.secretary);

        System.out.println(director);
    }
}
