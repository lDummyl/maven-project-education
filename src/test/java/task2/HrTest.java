package task2;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HrTest {

    Hr hr = new Hr();

    @Test
    public void objectDoesntInstanceOfEmployee() {
        class Test{}
        Test test = new Test();
        try {
            hr.checkEmployee(test);
            fail();
        } catch (ClassCastException e){}
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