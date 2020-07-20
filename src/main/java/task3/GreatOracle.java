package task3;

import java.time.LocalDateTime;
import java.util.*;

public class GreatOracle {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Statistics statistic = new Statistics();



    int rage;
    int needForSleep;
    Map<String, String> wisdom = new HashMap<>();
    LocalDateTime busyUntil;

    public GreatOracle(int rage, int needForSleep) {
        this.rage = rage;
        this.needForSleep = needForSleep;
    }

    public void learning(Map<String, String> wisdom){
        this.wisdom = wisdom;
    }

    static final List<String> curse = new ArrayList<>();

    static {
        curse.add("Какой же ты тупой!");
        curse.add("Может ты уже родишь свой вопрос?");
        curse.add("Зачем ты сюда пришел, болезный?");
        curse.add("Помню, была у меня собака. Так вот, она была сообразительнее тебя!");
        curse.add("Слушай, сгоняй мне за пивом.");
    }

    static final List<String> situation = new ArrayList<>();

    static {
        situation.add("Будь лаконичней.");
        situation.add("Будь красноречивее!");
        situation.add("Ты задаешь слишком много вопросов.");
        situation.add("Не слышу вопроса в твоих речах.");
    }


    QuestionExtractor questionExtractor = new QuestionExtractor(wisdom.keySet());

    public String questionListener(){
        String question = scanner.nextLine();
        return say(questionLength(question));
    }

    private String hitWithStick() {
        return "Hit";
    }

//        public void huff() {
//        int randomIndexCurse = random.nextInt(TextConstants.curse.size());
//        System.out.println(TextConstants.curse.get(randomIndexCurse));
//    }

    public String questionLength(String question) {
        int min = 15;
        int max = 40;
        char[] c = question.toCharArray();
        if (c.length < min) {
            return "-1";
        } else if (c.length > max) {
            return "-2";
        } else {
            return question;
        }
    }

    public String giveAnswer(String question){

        if (questionExtractor.parse(question).size() == 0){
            return situation.get(3);
        }else if (questionExtractor.parse(question).size() > 1){
            return situation.get(2);
        }else {
            return wisdom.get(questionExtractor.parse(question));
        }
    }

    public String say(String question) {
        if(question.equals("-1")){
            return situation.get(1);
        }else if (question.equals("-2")){
            return situation.get(0);
        }else {
            return giveAnswer(question);
        }
    }


    private boolean isBusy() {
        LocalDateTime now = LocalDateTime.now();
        if (busyUntil.isAfter(now)) {
            return true;
        }
        boolean b = random.nextBoolean();
        if (b) {
            busyUntil = now.plusMinutes(10);
        }
        return false;
    }


    private List<String> parseAllQuestionWords(String question) {
        // TODO: 16.07.2020 replace with parsing
        ArrayList<String> strings = new ArrayList<>();
        strings.add("как");
        return strings;

    }
}
