package task1;


import org.junit.Test;


import static org.junit.Assert.*;


public class PersonTest {
    @Test
    public void constructorTest() {
        int yearOfBirth = 1980;
        int monthOfBirth = 8;
        int dayOfBirth = 8;

        BirthDate birthDate = new BirthDate(yearOfBirth, monthOfBirth, dayOfBirth);
        String personName = "john Calivan";
        Person john = new Person(personName, birthDate);

        assertNotNull(john);
        assertNotNull(john.getBirthDate());
        assertNotNull(john.getName());

        assertEquals(birthDate, john.getBirthDate());
    }
    @Test
    public void constructorSecondTest() {
        int yearOfBirth = 1980;
        int monthOfBirth = 8;
        int dayOfBirth = 8;

        BirthDate birthDate = new BirthDate(yearOfBirth, monthOfBirth, dayOfBirth);

        String personName = "john Calivan";
        Name name = new Name(personName);

        Person john = new Person(name, birthDate);

        assertNotNull(john);
        assertNotNull(john.getBirthDate());
        assertNotNull(john.getName());

        assertEquals(birthDate, john.getBirthDate());
    }

    @Test
    public void birthdateFieldTest(){
        int yearOfBirth = 1980;
        int monthOfBirth = 8;
        int dayOfBirth = 8;

        BirthDate birthDate = new BirthDate(yearOfBirth, monthOfBirth, dayOfBirth);

        assertEquals(birthDate.getDay(), dayOfBirth);
        assertEquals(birthDate.getYear(), yearOfBirth);
        assertEquals(birthDate.getMonth(), monthOfBirth);
    }
    @Test
    public void nameToStringTest(){

        String personName = "john Calivan";
        Name name = new Name(personName);
        assertNotNull(personName);
    }
}
