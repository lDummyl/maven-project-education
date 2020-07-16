package task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GreatOracle {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Statistics statistic = new Statistics();

    public void start() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (thread2.isAlive()) {
                try {
                    Thread.sleep(random.nextInt(20000) + 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sticks();

            }
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                String question = scanner.nextLine();
                if (question.equals("0")) {
                    try {
                        statistic.endSession();
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    listenerQuestion(question);
                }
            }

        }
    });

    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (thread2.isAlive()) {
                try {
                    Thread.sleep(random.nextInt(22000) + 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                huff();
            }
        }
    });

    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (thread2.isAlive()) {
                try {
                    Thread.sleep(random.nextInt(30000) + 10000);
                    sleepOracle(random.nextInt(50000) + 10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    public void sticks() {
        System.out.println("*Оракул ударил вас палкой*");
    }

    public void sleepOracle(int time) throws InterruptedException {
        for (int i = time / 1000; i >= 0; i--) {
            System.out.println("Оракул уснул. До пробуждения осталось: " + ((i > 4 || i == 0) ? i + " секунд" : (i > 1) ? i + " секунды" : i + " секунда"));
            Thread.sleep(1000L);

        }
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

    public void advice(int questionCount) {

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

//    public String answerMyQuestion(String question) {
//        List<String> questions = parseAllQuestionWords(question);
//        return processQuestion(questions);
//
//
//    }
//
//    private String processQuestion(List<String> questions) {
//        if (questions.size() > 1) {
//
//        }
//        if (questions.size() == 0) {
//
//        }
//        if (questions.size() == 1) {
//            if (isBusy()) {
//                hitWithStick();
//            } else {
//                return "Прямо и направо";
//            }
//        }
//        return null;
//    }
//
//    LocalDateTime busyUntil;
//
//    private boolean isBusy() {
//        LocalDateTime now = LocalDateTime.now();
//        if (busyUntil.isAfter(now)) {
//            return true;
//        }
//        boolean b = random.nextBoolean();
//        if (b) {
//            busyUntil = now.plusMinutes(10);
//        }
//        return false;
//    }
//
//    private String hitWithStick() {
//        return "Hit";
//    }
//
//    private List<String> parseAllQuestionWords(String question) {
//        // TODO: 16.07.2020 replace with parsing
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("как");
//        return strings;
//
//    }
}
