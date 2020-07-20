package task3;

import java.util.*;

public class Academy {
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

    static List<String> question= new ArrayList<>();

    static {
        question.add("что");
        question.add("где");
        question.add("когда");
        question.add("почему");
        question.add("зачем");
        question.add("сколько");
        question.add("откуда");
        question.add("какой");
        question.add("какая");
        question.add("какое");
        question.add("как");
    }

    public Map<String, String> learnOracle(int indexWisdom){
        int maxIndexWisdom = question.size();
        Map<String, String> wisdom = new HashMap<>();
        if(indexWisdom <= maxIndexWisdom) {
            for (int i = 0; i < indexWisdom; i++) {
                wisdom.put(question.get(i), questionAnswer.get(question.get(i)));
            }
        }else {
            throw new RuntimeException("indexWisdom should be less " + maxIndexWisdom);
        }
        return wisdom;
    }
}

