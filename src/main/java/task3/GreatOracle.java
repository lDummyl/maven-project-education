package task3;

import java.time.LocalDateTime;
import java.util.*;

public class GreatOracle {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Statistics statistic = new Statistics();
    private final int MAX_POSSIBILITY = 100;



    int rage;
    int needForSleep;
    Map<String, String> wisdom = new HashMap<>();
    LocalDateTime busyUntil;
    QuestionExtractor questionExtractor;

    public GreatOracle(int rage, int needForSleep) {
        this.rage = rage;
        this.needForSleep = needForSleep;
    }

    public void learning(Map<String, String> wisdom){
        this.wisdom = wisdom;
        questionExtractor = new QuestionExtractor(wisdom.keySet());
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

    public String questionListener(){
        String question = scanner.nextLine();
        int action = random.nextInt(MAX_POSSIBILITY);
        if (action > 0 && action <= rage){
            hitWithStick();
        }else if (action > rage && action <= needForSleep){
            sleep();
        }else if (action > needForSleep && action <= MAX_POSSIBILITY){
            return say(questionLength(question));
        }
        return null;
    }

    private String hitWithStick() {
        return "Hit";
    }

//        public void huff() {
//        int randomIndexCurse = random.nextInt(TextConstants.curse.size());
//        System.out.println(TextConstants.curse.get(randomIndexCurse));
//    }

    // TODO: 7/22/20 представь что читаешь все что ниже в первый раз, что это чужой код в который ты вникаешь,
    //  если метод не удается назвать по принципу что я тут делаю(void) или получаю то что-то не так с ним.
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
        String s = questionExtractor.parse123(question);
        if (s.equals("-10")){
            return situation.get(3);
        }else if (s.equals("-20")){
            return situation.get(2);
        }else {
            return wisdom.get(s);
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
}
