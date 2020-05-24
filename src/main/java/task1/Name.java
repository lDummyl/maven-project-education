package task1;

public class Name {

    String firstName;
    String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
