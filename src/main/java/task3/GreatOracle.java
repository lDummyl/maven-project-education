package task3;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GreatOracle {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Statistics statistic = new Statistics();
    private final int MAX_POSSIBILITY = 100;



    int rage;
    int needForSleep;
    int qtyAnswer;
    Map<String, String> wisdom = new HashMap<>();
    QuestionExtractor questionExtractor;

    public GreatOracle(int rage, int needForSleep, int qtyAnswer) {
        this.rage = rage;
        this.needForSleep = needForSleep;
        this.qtyAnswer = qtyAnswer;
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

    public String questionListener(String question){
            int action = random.nextInt(MAX_POSSIBILITY);
            if (action > 0 && action <= rage) {
                if (random.nextBoolean()) {
                    return hitWithStick();
                } else {
                    return swear();
                }
            } else if (action > rage && action <= needForSleep) {
                oracleSleep(random.nextInt(60));
            } else if (action > needForSleep) {
                String answer = String.valueOf(getAnswer(validLengthQuestion(question)));
                statistic.saveStatistic(question, answer);
                return answer;
            }
        return "";
    }

    public void makeReport() {
        try {
            statistic.endSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToStatistics(){

    }

    public String hitWithStick() {
        return "*Ударить палкой*";
    }
    public String swear(){
        return curse.get(random.nextInt(curse.size()));
    }


    public void oracleSleep(int sleep) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss");
        LocalDateTime dateTime = LocalDateTime.of(0,1,1,0,0,0);
        LocalDateTime dateTime1 = dateTime.plusSeconds(sleep);
        while (dateTime.isBefore(dateTime1)){
            System.out.println("Оракул спит. До его пробуждения осталось: " + dateTime1.format(formatter));
            dateTime1 = dateTime1.minusSeconds(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Оракул прослулся!");
    }

    // TODO: 7/22/20 представь что читаешь все что ниже в первый раз, что это чужой код в который ты вникаешь,
    //  если метод не удается назвать по принципу что я тут делаю(void) или получаю то что-то не так с ним.
    public String validLengthQuestion(String question) {
        int min = 15;
        int max = 40;
        char[] c = question.toCharArray();
        if (c.length < min) {
            return "-00";
        } else if (c.length > max) {
            return "-000";
        } else {
            return question;
        }
    }

    public List<String> getAnswer(String question){
        List<String> answer = new ArrayList<>();
        if(question.equals("-00")){
            answer.add(Situation.SHORT.answer);
            return answer;
        }else if(question.equals("-000")){
            answer.add(Situation.LONG.answer);
            return answer;
        }else {
            List<String> questionList = questionExtractor.parse123(question);
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
