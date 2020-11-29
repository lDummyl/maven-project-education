package task2;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HrTest {

    Hr hr = new Hr();

    @Test(expected = ClassCastException.class)
    public void objectDoesntInstanceOfEmployee() {
        class TestClass {}
        TestClass test = new TestClass();
        hr.checkEmployee(test);

    }

    @Test
    public void checkLevelOfSkillsAndCreateNewArrayList() {
        Secretary secretary = new Secretary();
        hr.checkEmployee(secretary);
        Map<Class<?>, List<Employee>> listMap = hr.getListEmployee();
        if (secretary.skills.getLevelOfSkills() < 5) {
            assertNull(listMap.get(Secretary.class));
        } else {
            assertEquals(1, listMap.get(Secretary.class).size());
        }

    }
}