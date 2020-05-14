package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Oracul {
    public static void oraculAnswer() {
        int x = questionLength();
        if (x > 1) {
            System.out.println("Ты задаешь слишком много вопросов!");
        } else if (x == 1) {
            try {
                if (new Random().nextInt(3) == 2) {
                    int z = new Random().nextInt(6000);
                    System.out.println("Дай подумать оракулу " +  z/100 + " секунд!");
                    Thread.sleep(z);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getAnswer());
        } else if (x == 0) {
            System.out.println("Не слышу вопроса в твоих речах");
        }
        oraculAnswer();
    }

    public static int questionLength() {
        String s = new Scanner(System.in).nextLine();
        if (s.length() > 50) {
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
        return answers.get(new Random().nextInt(answers.size()));
    }


}
