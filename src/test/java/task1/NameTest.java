package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    @Test
    public void personContainName(){
        PersonProvider personProvider = new PersonProvider();
        Person person = personProvider.getSomePerson();
        assertNotNull(person.getName());
        assertNotNull(person.getAge());

    }

}