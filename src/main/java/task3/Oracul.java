package task3;

import java.util.*;

public class Oracul {
    Random random = new Random();
    String text = new Scanner(System.in).nextLine();

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    // TODO: 5/15/20 оракул не должен быть статическим он может менять ключевые аспекты поведения в зависимости от того какими полями инициализирован его инстанс
    public void oraculAnswer() throws InterruptedException {
        int x = checkForLength();
        checkForAnswer(x);
        text = new Scanner(System.in).nextLine();
        oraculAnswer();
    }

    public void checkForAnswer(int x) {
        if (x > 1) {
            firstAnswer();
        } else if (x == 1) {
            timeToAnswer();
            answer();
        } else if (x == 0) { // TODO: 5/15/20 сделай методы проверки checkForLength, ... и вынеси в них логику
            secondAnswer();
        }
    }

    public void firstAnswer() {
        System.out.println("Ты задаешь слишком много вопросов!");
    }

    public void secondAnswer() {
        System.out.println("Не слышу вопроса в твоих речах");
    }

    public void timeToAnswer() {
        try {
            int z = random.nextInt(6000); // TODO: 5/15/20 каждый раз создавать новый рандом плохая практика (создал рандом в классе Оракул)
            System.out.printf("Дай подумать оракулу %d  секунд!\n", z / 1000); // TODO: 5/15/20 сколько оракул думает это не плохая характеристика(поле) его как объекта класса
            Thread.sleep(z);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int checkForLength() {
        if (this.text.length() > 50) {
            // TODO: 5/15/20 всегда нужно отделать ввод-логика-вывод. что если нужно будет версию в выводом в окно, везде sout менять придется?
            longAnswer();
            return -1;
        }
        if (this.text.length() < 15) {
            shortAnswer();
            return -1;
        } else {
            return quantityOfQuestions();
        }
    }

    public void longAnswer() {
        // TODO: 5/19/20 это не то что я имел в виду, это будет легко понять когда примешься за тестирование. Но я бы начал с задачи 1 и 2 упражняться в написании unit тестов
        System.out.println("Будь лаконичней!");
    }

    public void shortAnswer() {
        System.out.println("Будь красноречивее!");
    }


    public int quantityOfQuestions() {
        String[] q = stringArrayOfQuestion();
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

    public String[] stringArrayOfQuestion() {
        String[] q = text.trim().replaceAll("\\pP", "").split(" ");
        return q;
    }

    public void answer() {
        // TODO: 5/15/20 все же должно быть соответствие на вопрос как не стоит отвечат так же как на когда,
        //  но вариантов ответа на каждый вопрос может быть несколько, например так Map<Question, List<Answer>>

        // TODO: 5/19/20 читаемость такого кода довольно затруднительна
        System.out.println(getMap().get(stringArrayOfQuestion()[0]).get(random.nextInt(3)));
    }


    public Map<String, List<String>> getMap() {
        // TODO: 5/19/20 каждый раз создавать новый экземпляр одинакового объекта не оченшь хорошо, как и наполнять коллекцию одновременно с ее выдачей.
        map.put("Что", new Answer().getAnswersWhat());
        map.put("Где", new Answer().getanswersWhere());
        map.put("Когда", new Answer().getanswersWhen());
        map.put("Зачем", new Answer().getanswersWherefore());
        map.put("Почему", new Answer().getanswersWhy());
        map.put("Кто", new Answer().getanswersWho());
        return map;
    }
}
