package task2;

import java.util.ArrayList;
import java.util.List;


// TODO: 5/22/20 этот класс живет в 1й таске, его ну нужно переносить чтобы использовать
public class Name {

    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // TODO: 5/22/20 пойбирай статические методы отовсюду
    public static List<Name> getNames() {
        List<Name> names;
        names = new ArrayList<>();
        names.add(new Name("Nina", "I"));
        names.add(new Name("Masha", "O"));
        names.add(new Name("Sergey", "M"));
        names.add(new Name("Ivan", "K"));
        names.add(new Name("Vasily", "S"));
        names.add(new Name("Ruslan", "Z"));
        names.add(new Name("Irina", "P"));
        names.add(new Name("Tanya", "E"));
        return names;
    }



}
