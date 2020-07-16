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

    public void learning(Map<String, String> data){
        this.wisdom = data;
    }


    private String hitWithStick() {
        return "Hit";
    }

    public void sleepOracle(int time) throws InterruptedException {

    }

    public void huff() {
        int randomIndexCurse = random.nextInt(TextConstants.curse.size());
        System.out.println(TextConstants.curse.get(randomIndexCurse));
    }

    public void questionLength(String question) {
        int min = 15;
        int max = 40;
        char[] c = question.toCharArray();
        if (c.length < min) {
            System.out.println(TextConstants.situation.get(1));
        } else if (c.length > max) {
            System.out.println(TextConstants.situation.get(0));
        } else {
            giveAdvice(question);
        }
    }

    public void giveAdvice(String question) {
        String smallLiteral = question.toLowerCase();
        String[] questionWords = smallLiteral.split("\\s");
        int equationCount = 0;
        String approvedQuestion = "";
        for (String questionWord : questionWords) {
            if (TextConstants.questionAnswer.containsKey(questionWord)) {
                approvedQuestion = questionWord;
                equationCount++;
            }
        }
        if (equationCount == 0) {
            statistic.saveStatistic(question, TextConstants.situation.get(3));
            System.out.println(TextConstants.situation.get(3));
        } else if (equationCount > 1) {
            statistic.saveStatistic(question, TextConstants.situation.get(2));
            System.out.println(TextConstants.situation.get(2));
        } else if (equationCount == 1) {
            statistic.saveStatistic(question, TextConstants.getAnswer(approvedQuestion));
            System.out.println(TextConstants.getAnswer(approvedQuestion));
        }
    }

    public void listenerQuestion(String question) {
        questionLength(question);
    }

    public String answerMyQuestion(String question) {
        List<String> questions = parseAllQuestionWords(question);
        return processQuestion(questions);


    }

    private String processQuestion(List<String> questions) {
        if (questions.size() > 1) {

        }
        if (questions.size() == 0) {

        }
        if (questions.size() == 1) {
            if (isBusy()) {
                hitWithStick();
            } else {
                return "Прямо и направо";
            }
        }
        return null;
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
