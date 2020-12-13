package task3;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Oracle {
    String answer;

    public Oracle() throws IOException {
    }

    ArrayList<String> specialQuestions = new ArrayList<>(Arrays.asList("кто", "что", "когда", "как", "зачем", "почему", "где", "куда", "откуда"));

    public int random(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        return min + i;
    }

    public void rude() {
        answer = "Вопрос не стоит моего внимания";
        System.out.println(answer);
    }

    public void hit() {
        answer = "Стукнуть палкой";
        System.out.println(answer);
    }

    public void relax() {
        int second = 1;
        int minute = 60;
        int sleepTime = random(10 * second, minute);
        for (int i = sleepTime; i > 0; ) {
            answer = "Оракул устал. Нужно подождать " + i + " секунд";
            System.out.println(answer);
            i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                answer = "Сон оракула прерван!";
                System.out.println(answer);
            }
        }
    }

    public String answer(String question) {
        for (Map.Entry<String, String> item : listOfAphorisms.entrySet()) {
            if (question.contains(item.getKey())) {
                answer = item.getValue();
                System.out.println(answer);
            }
        }
        return answer;
    }

        public boolean isContainsQuestion(List <String> specialQuestions, String question){
        boolean isQuestion = false;
            for (String specialQuestion : specialQuestions) {
                Pattern pattern = Pattern.compile("(?:^|[^а-яА-ЯёЁ])(?:" + specialQuestion + ")(?![а-яА-ЯёЁ]).*");
                Matcher matcher = pattern.matcher(question);
                isQuestion = matcher.matches();
                if (isQuestion)
                    break;
            }
            return isQuestion;
        }


    HashMap<String, String> listOfAphorisms = new HashMap<>();

    {
        listOfAphorisms.put(specialQuestions.get(0), "Благородный человек предъявляет требования к себе, низкий человек предъявляет требования к другим");
        listOfAphorisms.put(specialQuestions.get(1), "Лишь когда приходят холода, становится ясно, что сосны и кипарисы последними теряют свой убор");
        listOfAphorisms.put(specialQuestions.get(2), "Возможно, что никогда");
        listOfAphorisms.put(specialQuestions.get(3), "Три вещи никогда не возвращаются обратно – время, слово, возможность. Поэтому: не теряй времени, выбирай слова, не упускай возможность");
        listOfAphorisms.put(specialQuestions.get(4), "Легче зажечь одну маленькую свечу, чем клясть темноту");
        listOfAphorisms.put(specialQuestions.get(5), "Пришло несчастье – человек породил его, пришло счастье – человек его вырастил");
        listOfAphorisms.put(specialQuestions.get(6), "Разве истинная человечность далеко от нас? Стоит возжелать ее, и она тут же окажется рядом!");
        listOfAphorisms.put(specialQuestions.get(7), "Бросая камень в воду, каждый раз попадаешь в центр круга");
        listOfAphorisms.put(specialQuestions.get(8), "Того, кто не задумывается о далеких трудностях, непременно поджидают близкие неприятности");
    }

    int amountOfSpecialQuestions = 0;

    public String checkQuestion(String question) {
        if (question.length() > 30) {
            answer = "Будь лаконичнее";
            System.out.println(answer);
            return answer;
        }
        if (question.length() < 10) {
            answer = "Будь красноречивее";
            System.out.println(answer);
            return answer;
        }
        else if (isContainsQuestion(specialQuestions, question)) {
            amountOfSpecialQuestions++;
            if (amountOfSpecialQuestions > 1) {
                answer = "Ты задаешь слишком много вопросов";
                System.out.println(answer);
                return answer;
            }
            else if (amountOfSpecialQuestions == 1) {
                return answer(question);
            }
            else if (amountOfSpecialQuestions == 0) {
                answer = "Не слышу вопроса в твоих речах";
                System.out.println(answer);
                return answer;
            }
        }
        return answer;
    }

//    public void launch() {
//        if (checkQuestion()) {
//            int percent = random(1, 100);
//            if (percent <= 5) {
//                relax();
//            } else if (percent <= 15) {
//                rude();
//            } else if (percent <= 20) {
//                hit();
//            } else {
//                answer();
//            }
//        }
//    }

    public String giveAnswer(String question) {
        return "ok";
    }
}

