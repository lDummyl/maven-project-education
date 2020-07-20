package task3;

import java.util.*;
import java.util.stream.Collectors;

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

    // TODO: 7/21/20 это тебе не нужно, это добывается как questionAnswer.keyset() в любой момент, а это требует сверки
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

    // TODO: 7/21/20 осваивай функциональное программирование
    public static  Map<String, String> learnOracle1(int indexWisdom){
        if (indexWisdom > questionAnswer.size()){
            // TODO: 7/21/20 если эта проверка только чтобы за индексы не уехать, в данной реализации этого можно не опасаться,
            //  он просто не будет резать, а соберет все что есть при превышении, и так 1 строка пойдет за 10ть.
            throw new RuntimeException("indexWisdom should be less than - " + questionAnswer.size());
        }
        return questionAnswer.entrySet().stream().limit(indexWisdom)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

