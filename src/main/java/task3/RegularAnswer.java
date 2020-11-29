package task3;

import java.util.HashMap;

public class RegularAnswer {
    public static final HashMap<String, String> answers = new HashMap<>();

    static {
        answers.put("Что", "С точки зрения банальной эрудиции, каждый индивидуум, критически мотивирующий абстракцию," + "\n" +
                " не может игнорировать критерии утопического субъективизма, концептуально интерпретируя общепринятые " + "\n" +
                "дефанизирующие поляризаторы, поэтому консенсус, достигнутый диалектической материальной классификацией " + "\n" +
                "всеобщих мотиваций в парадигматических связях предикатов, решает проблему усовершенствования формирующих " + "\n" +
                "геотрансплантационных квазипузлистатов всех кинетически кореллирующих аспектов.");

        answers.put("Когда", " Я думаю, мы еще вернемся к этой теме и не раз. И это говорит о том, что все идет " + "\n" +
                "в правильном направлении. А детали мы будем решать по ходу дела.");

        answers.put("Почему", "Так исторически сложилось");

        answers.put("Кто", "Иногда ответ в загадке бывает настолько явным, что мы просто его не замечаем.");

        answers.put("Где", "Огромная мудрость сокрыта в каждом из нас. Ведь на все вопросы, которые мы задаем, у нас уже есть ответы.");

        answers.put("Зачем", "Такова структура момента.");

        answers.put("Куда", " Ну, тогда все равно и куда идти...");

        answers.put("Сколько", " Сколько нужно...");

        answers.put("Как", " Собравшись с духом");

        answers.put("rudeness", "Дай-ка угадаю, кто-то украл твой сладкий рулет?");

        answers.put("tooLong", "Будь лаконичнее");

        answers.put("tooShort" ,"Будь красноречивие");

        answers.put("noKey", "Не еслышу вопроса в речах твоих");

        answers.put("moreKey", "Ты задаешь слишком много вопросов");

        answers.put("stickHit" , "(；一_一) ┻━┻༼ つ ಥ_ಥ ༽つ" + "\n" + "-Оракул бьёт вас палкой");

    }

    public static String getAnswer(String key) {
        return answers.get(key);
    }
}
