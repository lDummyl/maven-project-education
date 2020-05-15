package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Oracul {
    // TODO: 5/15/20 оракул не должен быть статическим он может менять ключевые аспекты поведения в зависимости от того какими полями инициализирован его инстанс
    public static void oraculAnswer() {
        int x = questionLength();
        if (x > 1) {
            System.out.println("Ты задаешь слишком много вопросов!");
        } else if (x == 1) {
            try {
                if (new Random().nextInt(3) == 2) {
                    int z = new Random().nextInt(6000); // TODO: 5/15/20 каждый раз создавать новый рандом плохая практика
                    System.out.println("Дай подумать оракулу " +  z/100 + " секунд!"); // TODO: 5/15/20 сколько оракул думает это не плохая характеристика(поле) его как объекта класса
                    Thread.sleep(z);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getAnswer());
        } else if (x == 0) { // TODO: 5/15/20 сделай методы проверки checkForLength, ... и вынеси в них логику
            System.out.println("Не слышу вопроса в твоих речах");
        }
        oraculAnswer();
    }

    public static int questionLength() {
        String s = new Scanner(System.in).nextLine();
        if (s.length() > 50) {
            // TODO: 5/15/20 всегда нужно отделать ввод-логика-вывод. что если нужно будет версию в выводом в окно, везде sout менять придется?
            System.out.println("Будь лаконичней!");
            return -1;
        }
        if (s.length() < 15) {
            System.out.println("Будь красноречивее!");
            return -1;
        } else {
            return quantityOfQuestions(s);
        }
    }

    public static int quantityOfQuestions(String s) {
        String[] q = s.trim().replaceAll("\\pP", "").split(" ");
        int count = 0;
        // TODO: 5/15/20  бы сделал лучше мапу соответствия вопрос ответ или вопрос-список ответов
        for (int i = 0; i < q.length; i++) {
            if (q[i].equals("Что")) {
                count++;
            }
            if (q[i].equals("Где")) {
                count++;
            }
            if (q[i].equals("Когда")) {
                count++;
            }
            if (q[i].equals("Зачем")) {
                count++;
            }
            if (q[i].equals("Почему")) {
                count++;
            }
            if (q[i].equals("Кто")) {
                count++;
            }
        }
        return count;
    }

    public static String getAnswer() {
        List<String> answers = new ArrayList<>();
        answers.add("Не ищи счастье – оно всегда у тебя внутри.");
        answers.add("Лучше помолчать, чем  говорить без смысла.");
        answers.add("Тому, кто никуда не плывёт, — не бывает попутного ветра!");
        answers.add("Кто сражается с чудовищами, тому следует остерегаться, чтобы самому при этом не стать чудовищем. " +
                "И если ты долго смотришь в бездну, то бездна тоже смотрит в тебя.");
        answers.add("Не бойся, что не знаешь — бойся, что не учишься.");
        answers.add("Незнание — это не проблема, если есть желание учиться.");
        answers.add("Зачем ты задаешь такие странные вопросы, глупец?!!");
        // TODO: 5/15/20 все же должно быть соответствие на вопрос как не стоит отвечат так же как на когда,
        //  но вариантов ответа на каждый вопрос может быть несколько, например так Map<Question, List<Answer>>
        return answers.get(new Random().nextInt(answers.size()));
    }


}
