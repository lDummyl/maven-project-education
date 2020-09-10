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


    // TODO: 7/21/20 это тебе не нужно, это добывается как questionAnswer.keyset() в любой момент, а это требует сверки


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

    public static List<String> learnStudent(){
        List<String> questions = new ArrayList<>();
        questions.addAll(questionAnswer.keySet());
        return questions;
    }
}

