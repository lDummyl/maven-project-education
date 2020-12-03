package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    @Test
    public void generateName() {
        Name name = new Name();
        assertNotNull(name);
    }
}