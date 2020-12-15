package task3;

import java.util.EnumMap;

public enum OracleCharacters {

    KIND(5, 5, 1),
    ANGRY(20, 20, 1),
    TIRED(5, 5, 1);

    private int rudenessChance, stickHitChance, sleepChance;

    OracleCharacters(int rudenessChance, int stickHitChance, int sleepChance) {
        this.rudenessChance = rudenessChance;
        this.stickHitChance = stickHitChance;
        this.sleepChance = sleepChance;
    }

    public int getRudenessChance() {
        return rudenessChance;
    }

    public int getStickHitChance() {
        return stickHitChance;
    }

    public int getSleepChance() {
        return sleepChance;
    }
}
