package task2;

import java.util.Random;

public class Skills {

    private final int levelOfSkills;
    private static final int MAX_SKILLS = 10;

    public Skills() {
        Random random = new Random();
        this.levelOfSkills = random.nextInt(MAX_SKILLS);
    }

    public int getLevelOfSkills() {
        return levelOfSkills;
    }

    @Override
    public String toString() {
        return levelOfSkills + "";
    }
}
