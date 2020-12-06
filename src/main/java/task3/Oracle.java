package task3;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class Oracle {
    private final int allChances = 100;
    private int maximumSleepTimeSec = 59;

    public static final int maxLength = 30;
    public static final int minLength = 15;

    Random random = new Random();
    LocalDateTime stopSleepTime = LocalDateTime.now();

    public static final String[] specialQuests = {"Кто", "Что", "Где", "Когда", "Почему", "Зачем", "Куда", "Сколько", "Как"};

    public static final String left = "Ещё осталось: ";

    public Oracle() {
    }

    public void setMaximumSleepTimeSec(int maximumSleepTimeSec) {
        this.maximumSleepTimeSec = maximumSleepTimeSec;
    }

    public Resolution ask(String question) {
        if (LocalDateTime.now().isAfter(stopSleepTime)) {
            try {
                lengthCheck(question);
                questionPresenceCheck(question);
                moodCheck();
                fatigueCheck();
                return validAnswer(question);
            } catch (OracleException e) {
                OracleReaction reaction = e.reaction;
                return new Resolution(question, reaction.getValue());
            }
        } else {
            return new Resolution(question, left + Duration.between(LocalDateTime.now(), stopSleepTime).toString());
        }
    }


    private void lengthCheck(String question) throws OracleException {
        if (question.length() < minLength) {
            throw new OracleException(OracleReaction.TOO_SHORT);
        } else if (question.length() > maxLength) {
            throw new OracleException(OracleReaction.TOO_LONG);
        }
    }

    private Resolution validAnswer(String question) throws OracleException {

        return new Resolution(question, RegularAnswer.getAnswer(keyWordSearch(question).get(0)));
    }

    // TODO: 03.12.2020 Механизм сна пока прежний
    private void fatigueCheck() {
        int current = random.nextInt(allChances);
        int sleepChance = 1;
        if (current < sleepChance) {
            this.stopSleepTime = LocalDateTime.now().plusSeconds(1 + random.nextInt(maximumSleepTimeSec));
        }
    }

    private void moodCheck() throws OracleException {
        int current = random.nextInt(allChances);
        int rudenessChance = 10;
        int stickHitChance = 20;

        if (current <= rudenessChance) {
            throw new OracleException(OracleReaction.RUDENESS);
        } else if (current < stickHitChance) {
            throw new OracleException(OracleReaction.STICK_HIT);
        }
    }

    private void questionPresenceCheck(String question) throws OracleException {
        ArrayList<String> keyWords = keyWordSearch(question);


        if (keyWords.size() < 1) {
            throw new OracleException(OracleReaction.NO_KEY_WORT);
        } else if ((keyWords.size() > 1)) {
            throw new OracleException(OracleReaction.TO_MATCH_KEY_WORT);
        }
    }

    private ArrayList<String> keyWordSearch(String question) {
        ArrayList<String> keyWord = new ArrayList<>();
        for (String s : specialQuests) {
            if (question.contains(s) || question.contains(s.toLowerCase())) {
                keyWord.add(s);
            }
        }
        return keyWord;
    }

}


