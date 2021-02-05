package task3;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import static task3.Character.*;


public class Oracle {
    private int maximumSleepTimeSec = 59;

    public static final int maxLength = 30;
    public static final int minLength = 15;

    Random random = new Random();
    LocalDateTime stopSleepTime = LocalDateTime.now();

    public static final String leftTimeToSleepMarker = "Ещё осталось: ";

    public static final Map<String, String> answers = new HashMap<>();
    public static final Map<Character, CharacterCoef> characters = new EnumMap<>(task3.Character.class);

    CharacterCoef character;


    static {
        answers.put("Что", "С точки зрения банальной эрудиции, каждый индивидуум, критически мотивирующий абстракцию," + "\n" +
                " не может игнорировать критерии утопического субъективизма, концептуально интерпретируя общепринятые " + "\n" +
                "дефанизирующие поляризаторы, поэтому консенсус, достигнутый диалектической материальной классификацией " + "\n" +
                "всеобщих мотиваций в парадигматических связях предикатов, решает проблему усовершенствования формирующих " + "\n" +
                "геотрансплантационных квазипузлистатов всех кинетически кореллирующих аспектов.");

        answers.put("Когда", " Я думаю, мы еще вернемся к этой теме и не раз. И это говорит о том, что все идет " + "\n" +
                "в правильном направлении. А детали мы будем решать по ходу дела.");

        answers.put("Почему", "Так исторически сложилось");

        answers.put("Кто", "Иногда ответ в загадке бывает настолько явным, что мы просто его не замечаем.");

        answers.put("Где", "Огромная мудрость сокрыта в каждом из нас. Ведь на все вопросы, которые мы задаем, у нас уже есть ответы.");

        answers.put("Зачем", "Такова структура момента.");

        answers.put("Куда", " Ну, тогда все равно и куда идти...");

        answers.put("Сколько", " Сколько нужно...");

        answers.put("Как", " Собравшись с духом");

        characters.put(KIND, new CharacterCoef(5, 5, 1));
        characters.put(ANGRY, new CharacterCoef(20, 20, 1));
        characters.put(TIRED, new CharacterCoef(5, 5, 10));

    }


    public Oracle() {


        Collection<CharacterCoef> values = characters.values();
        ArrayList<CharacterCoef> characterCoefs = new ArrayList<>(values);
        this.character = characterCoefs.get(random.nextInt(characterCoefs.size()));

    }

    public Oracle(Character character) {
        this.character = characters.get(character);
    }


    public void setMaximumSleepTimeSec(int maximumSleepTimeSec) {
        this.maximumSleepTimeSec = maximumSleepTimeSec;
    }

    public Resolution ask(String question) {
        if (LocalDateTime.now().isAfter(stopSleepTime)) {
            try {
                lengthCheck(question);
                moodCheck();
                fatigueCheck();
                return validAnswer(question);
            } catch (OracleException e) {
                OracleReaction reaction = e.reaction;
                return new Resolution(question, reaction.getValue(), LocalDateTime.now());
            }
        } else {
            return new Resolution(question, leftImeToSleep(), LocalDateTime.now());
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
        String key = questionPresenceCheck(question);
        return new Resolution(question, answers.get(key), LocalDateTime.now());
    }


    private void fatigueCheck() {
        int current = getMood();
        if (current < character.sleepChance) {
            this.stopSleepTime = LocalDateTime.now().plusSeconds(1 + random.nextInt(maximumSleepTimeSec));
        }
    }

    private void moodCheck() throws OracleException {


        if (getMood() <= character.rudenessChance ) {
            throw new OracleException(OracleReaction.RUDENESS);
        } else if (getMood() < character.stickHitChance) {
            throw new OracleException(OracleReaction.STICK_HIT);
        }
    }

    private int getMood() {
        int allChances = 100;
        return random.nextInt(allChances);
    }


    private String questionPresenceCheck(String question) throws OracleException {
        ArrayList<String> keyWords = keyWordSearch(question);

        if (keyWords.size() < 1) {
            throw new OracleException(OracleReaction.NO_KEY_WORT);
        } else if ((keyWords.size() > 1)) {
            throw new OracleException(OracleReaction.TO_MATCH_KEY_WORT);
        } else {
            return keyWords.get(0);
        }
    }

    private String leftImeToSleep() {
        String leftTime = (leftTimeToSleepMarker + Duration.between(LocalDateTime.now(), stopSleepTime).getSeconds() + "секунд");
        return leftTime;
    }

    private ArrayList<String> keyWordSearch(String question) {
        ArrayList<String> keyWord = new ArrayList<>();
        for (String s : Oracle.answers.keySet()) {
            if (question.contains(s) || question.contains(s.toLowerCase())) {
                keyWord.add(s);
            }
        }
        return keyWord;
    }

    static class CharacterCoef {
        int rudenessChance = 10;
        int stickHitChance = 20;
        int sleepChance = 1;

        public CharacterCoef(int rudenessChance, int stickHitChance, int sleepChance) {
            this.rudenessChance = rudenessChance;
            this.stickHitChance = stickHitChance;
            this.sleepChance = sleepChance;
        }
    }
}


