package task3;

import junit.framework.TestCase;

public class SpecialQuestTest extends TestCase {

    public void testSpecialQuestCheck() {
        SpecialQuest specialQuest = new SpecialQuest();

        String[] specialQuests = SpecialQuest.specialQuests;
        String current;

        for (String s : specialQuests) {
            current = "Jet" + s + " sasdf";
            assertEquals(s, specialQuest.specialQuestCheck(current));
            System.out.println(specialQuest.specialQuestCheck(current));
        }

        String check = "Here is no Special Quest";
        assertNull(specialQuest.specialQuestCheck(check));
    }

    public void testTestSpecialQuestCheck() {

    }

    public void testGetSpecialQuest() {
        String controlwordWithQuest = "Что вфыв";

        SpecialQuest specialQuest = new SpecialQuest();
        SpecialQuest specialQuest1 = new SpecialQuest(controlwordWithQuest);

        assertEquals("Что", specialQuest1.getSpecialQuest());
        assertNotNull(specialQuest1.specialQuest);
        assertNull( specialQuest.getSpecialQuest());
    }

}