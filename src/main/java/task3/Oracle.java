package task3;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Oracle {
    private final int allChances = 100;
    private int maximumSleepTimeSec = 59;

    public static final int maxLength = 30;
    public static final int minLength = 15;

    Random random = new Random();
    LocalDateTime stopSleepTime = LocalDateTime.now();

    public static final String leftTimeToSleepMarker = "Ещё осталось: ";

    public static final HashMap<String, String> answers = new HashMap<>();

    int rudenessChance = 10;
    int stickHitChance = 20;
    int sleepChance = 1;



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
    }

    public Oracle() {
    }


    public  void angryKindOrTired(String preset){
        if (preset.equals("angry")){
            this.
        }

    }
    public void temperamentPreset(){

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
                return new Resolution(question, reaction.getValue());
            }
        } else {
            return new Resolution(question, leftTimeToSleepMarker + Duration.between(LocalDateTime.now(), stopSleepTime).getSeconds());
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
        return new Resolution(question, answers.get(key));
    }

    // TODO: 03.12.2020 Механизм сна пока прежний
    private void fatigueCheck() {
        int current = random.nextInt(allChances);
        if (current < sleepChance) {
            this.stopSleepTime = LocalDateTime.now().plusSeconds(1 + random.nextInt(maximumSleepTimeSec));
        }
    }

    private void moodCheck() throws OracleException {
        int current = random.nextInt(allChances);


        if (current <= rudenessChance) {
            throw new OracleException(OracleReaction.RUDENESS);
        } else if (current < stickHitChance) {
            throw new OracleException(OracleReaction.STICK_HIT);
        }
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

    // TODO: 09.12.2020 Метод пока оставил
    private ArrayList<String> keyWordSearch(String question) {
        ArrayList<String> keyWord = new ArrayList<>();
        for (String s : Oracle.answers.keySet()) {
            if (question.contains(s) || question.contains(s.toLowerCase())) {
                keyWord.add(s);
            }
        }
        return keyWord;
    }

}


