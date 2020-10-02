package CollectionWork;


import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        assertTrue(false);
    }

    @Test
    //expected = RuntimeException.class)
    public void main2() {
        throw new RuntimeException();
    }
}