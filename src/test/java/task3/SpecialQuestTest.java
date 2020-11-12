package task3;

import junit.framework.TestCase;

public class SpecialQuestTest extends TestCase {

    public void testSpecialQuestCheck() {
        String[] specialQuests = SpecialQuest.specialQuests;
        String current;

        for (String s : specialQuests) {
            current = "Jet" + s + " sasdf";
            assertEquals(s, new SpecialQuest(current).getSpecialQuest().get(0));
        }

        for (int i = 0; i < specialQuests.length - 1; i++) {
            current = "Jet" + specialQuests[i] + " sasdf" + specialQuests[i+1];
            assertEquals(specialQuests[i], new SpecialQuest(current).getSpecialQuest().get(0));
            assertEquals(specialQuests[i+1], new SpecialQuest(current).getSpecialQuest().get(1));
        }


            current = "Jet";
            assertEquals(0, new SpecialQuest(current).getSpecialQuest().size());
    }

    public void testTestSpecialQuestCheck() {

    }

    public void testGetSpecialQuest() {
    }
}