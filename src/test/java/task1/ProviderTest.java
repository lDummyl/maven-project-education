package task1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProviderTest {

    @Test
    public void provide() {
        Provider<Person> provider = Person::new;
        List<Person> list = provider.provide(100);
        assertEquals(100, list.size());
    }
}