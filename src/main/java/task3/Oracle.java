package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Oracle {
    String answer;

    public Oracle() throws IOException {
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String question = reader.readLine();


    ArrayList<String> questions = new ArrayList<>(Arrays.asList("кто", "что", "когда", "как", "зачем", "почему", "где", "куда", "откуда"));

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

    public void answer() {
        for (Map.Entry<String, String> item : listOfAphorisms.entrySet()) {
            if (question.contains(item.getKey())) {
                answer = item.getValue();
                System.out.println(answer);
            }
        }
    }

    HashMap<String, String> listOfAphorisms = new HashMap<>();

    {
        listOfAphorisms.put(questions.get(0), "Благородный человек предъявляет требования к себе, низкий человек предъявляет требования к другим");
        listOfAphorisms.put(questions.get(1), "Лишь когда приходят холода, становится ясно, что сосны и кипарисы последними теряют свой убор");
        listOfAphorisms.put(questions.get(2), "Возможно, что никогда");
        listOfAphorisms.put(questions.get(3), "Три вещи никогда не возвращаются обратно – время, слово, возможность. Поэтому: не теряй времени, выбирай слова, не упускай возможность");
        listOfAphorisms.put(questions.get(4), "Легче зажечь одну маленькую свечу, чем клясть темноту");
        listOfAphorisms.put(questions.get(5), "Пришло несчастье – человек породил его, пришло счастье – человек его вырастил");
        listOfAphorisms.put(questions.get(6), "Разве истинная человечность далеко от нас? Стоит возжелать ее, и она тут же окажется рядом!");
        listOfAphorisms.put(questions.get(7), "Бросая камень в воду, каждый раз попадаешь в центр круга");
        listOfAphorisms.put(questions.get(8), "Того, кто не задумывается о далеких трудностях, непременно поджидают близкие неприятности");
    }

    int amountOfSpecialQuestions = 0;

    public boolean checkQuestion() {
        try {
            question = reader.readLine();
        } catch (IOException e) {
            System.out.println("Недопустимые символы");
        }
        if (question.length() > 30) {
            answer = "Будь лаконичнее";
            System.out.println(answer);
            return false;
        }
        if (question.length() < 10) {
            answer = "Будь красноречивее";
            System.out.println(answer);
            return false;
        }
        for (String s : questions) {
            if (question.contains(s)) {
                amountOfSpecialQuestions++;
            }
        }
        if (amountOfSpecialQuestions > 1) {
            answer = "Ты задаешь слишком много вопросов";
            System.out.println(answer);
            return false;
        }
        if (amountOfSpecialQuestions == 0) {
            answer = "Не слышу вопроса в твоих речах";
            System.out.println(answer);
            return false;
        }
        return true;
    }

    public void launch() {
        if (checkQuestion()) {
            int percent = random(1, 100);
            if (percent <= 5) {
                relax();
            } else if (percent <= 15) {
                rude();
            } else if (percent <= 20) {
                hit();
            } else {
                answer();
            }
        }
    }
}

