package task3;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Oracle {
    String answer;

    public Oracle() throws IOException {
    }

    HashMap<String, String> mapOfQuestionsAndAnswers = new HashMap<>();

    {
        mapOfQuestionsAndAnswers.put("кто", "Благородный человек предъявляет требования к себе, низкий человек предъявляет требования к другим");
        mapOfQuestionsAndAnswers.put("что", "Лишь когда приходят холода, становится ясно, что сосны и кипарисы последними теряют свой убор");
        mapOfQuestionsAndAnswers.put("когда", "Возможно, что никогда");
        mapOfQuestionsAndAnswers.put("как", "Три вещи никогда не возвращаются обратно – время, слово, возможность. Поэтому: не теряй времени, выбирай слова, не упускай возможность");
        mapOfQuestionsAndAnswers.put("зачем", "Легче зажечь одну маленькую свечу, чем клясть темноту");
        mapOfQuestionsAndAnswers.put("почему", "Пришло несчастье – человек породил его, пришло счастье – человек его вырастил");
        mapOfQuestionsAndAnswers.put("где", "Разве истинная человечность далеко от нас? Стоит возжелать ее, и она тут же окажется рядом!");
        mapOfQuestionsAndAnswers.put("куда", "Бросая камень в воду, каждый раз попадаешь в центр круга");
        mapOfQuestionsAndAnswers.put("откуда", "Того, кто не задумывается о далеких трудностях, непременно поджидают близкие неприятности");
        mapOfQuestionsAndAnswers.put("какая", "Прекрасная во всех отношениях");
        mapOfQuestionsAndAnswers.put("какой", "Безмятежный");
        mapOfQuestionsAndAnswers.put("сколько", "Время бесконечно");
    }

    public enum Action {
        SLEEP, HIT, RUDE, MORE_LACONIC, MORE_ELOQUENCE, MANY_QUESTIONS, NO_QUESTIONS
    }

    public HashMap<Action, String> invalidAnswers = new HashMap<>();

    {
        invalidAnswers.put(Action.SLEEP, "Оракул устал");
        invalidAnswers.put(Action.HIT, "Стукнуть палкой");
        invalidAnswers.put(Action.RUDE, "Вопрос не стоит моего внимания");
        invalidAnswers.put(Action.MORE_LACONIC, "Будь лаконичнее");
        invalidAnswers.put(Action.MORE_ELOQUENCE, "Будь красноречивее");
        invalidAnswers.put(Action.MANY_QUESTIONS, "Ты задаешь слишком много вопросов");
        invalidAnswers.put(Action.NO_QUESTIONS, "Не слышу вопроса в твоих речах");
    }

    private int random(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return min + i;
    }

    private void sleep() {
        int second = 1;
        int minute = 60;
        int sleepTime = random(10 * second, minute);
        int count = 0;
        for (int i = sleepTime; i >= second; i--) {
            answer = "Нужно подождать " + i + " секунд";
            count++;
            System.out.println(answer);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        answer = "Оракул отдыхал " + count;
    }

    private String[] separateQuestion (String question) {
        String[] rawWords = question.split(" ");
        for (String rawWord : rawWords) {
            String replace = rawWord.replaceAll(",", "");
        }
        return rawWords;
    }


    private String answer(String[] separatedQuestion) {
        for (Map.Entry<String, String> item : mapOfQuestionsAndAnswers.entrySet()) {
            for (String s : separatedQuestion) {
                if (s.equalsIgnoreCase(item.getKey())) {
                    answer = item.getValue();
                    System.out.println(answer);
                }
            }
        }
        return answer;
    }

    private int isContainsQuestion(Map<String, String> questionsAnswers, String[] separatedQuestion) {
        int amountOfSpecialQuestions = 0;
        for (String specialQuestion : questionsAnswers.keySet()) {
            for (String s : separatedQuestion) {
                if (specialQuestion.equalsIgnoreCase(s))
                    amountOfSpecialQuestions++;
            }
        }
        return amountOfSpecialQuestions;
    }

    private String checkLengthAndQtySpecialQuestions(String question) {
        String [] separatedQuestion = separateQuestion(question);
        int amountOfSpecialQuestions = isContainsQuestion(mapOfQuestionsAndAnswers, separatedQuestion);
        if (question.length() > 30) {
            answer = invalidAnswers.get(Action.MORE_LACONIC);
            System.out.println(answer);
            return answer;
        } else if (question.length() < 10) {
            answer = invalidAnswers.get(Action.MORE_ELOQUENCE);
            System.out.println(answer);
            return answer;
        } else if (amountOfSpecialQuestions > 1) {
            answer = invalidAnswers.get(Action.MANY_QUESTIONS);
            System.out.println(answer);
            return answer;
        } else if (amountOfSpecialQuestions == 1) {
            return answer(separatedQuestion);
        } else if (amountOfSpecialQuestions == 0) {
            answer = invalidAnswers.get(Action.NO_QUESTIONS);
            System.out.println(answer);
            return answer;
        }
        return answer;
    }

    public String giveAnswer(String question) throws IOException {
        int percent = random(1, 100);
        if (percent <= 5) {
            answer = invalidAnswers.get(Action.SLEEP);
            System.out.println(answer);
            sleep();
            return answer;
        } else if (percent > 6 && percent <= 10) {
            answer = invalidAnswers.get(Action.RUDE);
            System.out.println(answer);
            return answer;
        } else if (percent > 11 && percent <= 15) {
            answer = invalidAnswers.get(Action.HIT);
            System.out.println(answer);
            return answer;
        } else {
            return checkLengthAndQtySpecialQuestions(question);
        }
    }
}

