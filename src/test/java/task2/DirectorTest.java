package task2;

import org.junit.Test;
import task1.Name;
import task1.PersonProvider;

import java.util.List;

import static org.junit.Assert.*;

public class DirectorTest {
    PersonProvider personProvider = new PersonProvider();
    Director director = personProvider.getSomeDirector();
    List<Secretary> secretaries = personProvider.getSomeOf(Secretary.class, 10);

    public DirectorTest() throws Exception {
    }

    @Test
    public void createDirector(){
        assertNotNull(director.getName());
    }

    @Test(expected = RuntimeException.class)
    public void invite() {
        director.invite(secretaries, 20);
    }
}