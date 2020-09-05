package task3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class GreatOracle {
    Random random = new Random();
    private final int MAX_POSSIBILITY = 100;

    int rage;
    int needForSleep;
    int qtyAnswer;
    Map<String, String> wisdom = new HashMap<>();
    QuestionExtractor questionExtractor;

    public GreatOracle(int rage, int needForSleep, int qtyAnswer) {
        if(rage+needForSleep > MAX_POSSIBILITY){
            throw new OracleExceptions("Суммарная вероятность не должна превышать: ", MAX_POSSIBILITY);
        } else {
            this.rage = rage;
            this.needForSleep = needForSleep;
            this.qtyAnswer = qtyAnswer;
        }
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

    // TODO: 7/25/20 вот отсюда ...
    public int oracleMood(){
        return random.nextInt(MAX_POSSIBILITY);
    }

    public String questionListener(String question){
            int action = oracleMood();
            if (action > 0 && action <= rage) {
                if (random.nextBoolean()) {
                    return hitWithStick();
                } else {
                    return swear();
                }
            } else if (action > rage && action <= needForSleep+rage) {
                oracleSleep(random.nextInt(60)); // TODO: 7/25/20 исопльзуй Duration
            } else if (action > needForSleep+rage) {
                return String.valueOf(getAnswer(validLengthQuestion(question)));
            }
        return "";
    }

    // TODO: 7/29/20 оракул только отвечает на вопросы, он не пишет их на диск, не считывает их с консоли,
    //  не достает их по http, не анализирует статистику, только вопрос-ответ, выдели интерфейс оракула.


    public String hitWithStick() {
        return "*Ударить палкой*";
    }
    public String swear(){
        return curse.get(random.nextInt(curse.size()));
    }


    public void oracleSleep(int sleep) {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusSeconds(sleep);
        while (LocalDateTime.now().isBefore(to)){
            Duration sleepAge = Duration.between(LocalDateTime.now(), to);
            System.out.println("Оракул спит. До его пробуждения осталось: " + sleepAge.getSeconds() + "секунд");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Оракул прослулся!");
    }

    // TODO: 7/25/20 ...до сюда нет покрытия тестами.

    // TODO: 7/22/20 представь что читаешь все что ниже в первый раз, что это чужой код в который ты вникаешь,
    //  если метод не удается назвать по принципу что я тут делаю(void) или получаю то что-то не так с ним.
    public String /*попробуй вернуть Situation */validLengthQuestion(String question) {
        int min = 15;
        int max = 40;
        char[] c = question.toCharArray();
        if (c.length < min) {
            return "-00"; // TODO: 7/25/20 тут не покрыто
        } else if (c.length > max) {
            return "-000"; // TODO: 7/25/20 тут не покрыто
        } else {
            return question;
        }
    }

    public List<String> getAnswer(String question){
        List<String> answer = new ArrayList<>();
        if(question.equals("-00")){
            answer.add(Situation.SHORT.answer); // TODO: 7/25/20 тут не покрыто
            return answer;
        }else if(question.equals("-000")){
            answer.add(Situation.LONG.answer); // TODO: 7/25/20 тут не покрыто
            return answer;
        }else {
            List<String> questionList = questionExtractor.parseQuestion(question);
            if (questionList.size() == 0) {
                answer.add(Situation.NO_QUESTION.answer); // TODO: 7/23/20 изучай енумы, наглядно, не запутаешься
                return answer;
            } else if (questionList.size() > qtyAnswer) {
                answer.add(Situation.TOO_MUCH.answer);
                return answer;
            } else {
                for (String s : questionList) {
                    answer.add(wisdom.get(s));
                }
                return answer;
            }
        }
    }

    enum Situation {
        SHORT("Будь красноречивее!"),
        LONG("Будь лаконичней."),
        TOO_MUCH("Ты задаешь слишком много вопросов."),
        NO_QUESTION("Не слышу вопроса в твоих речах.");

        private  String answer;

        Situation(String s) {
            answer = s;
        }
    }
}
