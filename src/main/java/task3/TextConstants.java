package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextConstants {
    static Map<String, String> questionAnswer = new HashMap<>();
    static {
        questionAnswer.put("что", "Погугли.");
        questionAnswer.put("где", "Прямо и немножечко направо.");
        questionAnswer.put("когда", "После дождечка в четверг.");
        questionAnswer.put("почему", "По кочану и по кочерыжке.");
        questionAnswer.put("зачем", "Я сам ингда думаю, а зачем? Ну вот зачем-то.");
        questionAnswer.put("сколько", "Столько, сколько нужно. Ни больше, ни меньше.");
        questionAnswer.put("откуда", "Из-за леса, из-за гор.");
        questionAnswer.put("какой", "Красивый.");
        questionAnswer.put("какая", "Красивая.");
        questionAnswer.put("какое", "Красивое.");
        questionAnswer.put("как", "Хером об косяк!"); //Придумать мудрый ответ
    }

    static final List<String> curse = new ArrayList<>();
    static {
        curse.add("Какой же ты тупой!");
        curse.add("Может ты уже родишь свой вопрос?");
        curse.add("Зачем ты сюда пришел, болезный?");
        curse.add("Помню, была у меня собака. Так вот, она была сообразительнее тебя!");
        curse.add("Слушай, сгоняй мне за пивом.");
    }

    static final List<String> situation = new ArrayList<>();
    static {
        situation.add("Будь лаконичней.");
        situation.add("Будь красноречивее!");
        situation.add("Ты задаешь слишком много вопросов.");
        situation.add("Не слышу вопроса в твоих речах.");
    }

    public static String getAnswer(String question) {
        return questionAnswer.get(question);
    }

    public static String getCurse(int i) {
        return curse.get(i);
    }

//    public static String getSituation(Логика определения ситуации) {
//        return situation.get();
//    }
}
