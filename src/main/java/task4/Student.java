package task4;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private int qtyQuestion;

    private Set<String> keyQuestions = new HashSet<>();

    private Set<String> questionContextOne = new HashSet<>();

    private Set<String> questionContextTwo = new HashSet<>();

    public void learning (Set<String> wisdom){
        this.keyQuestions = wisdom;
    }

    private void initContextOne(){
        questionContextOne.add("купить");
        questionContextOne.add("ехать");
        questionContextOne.add("получить");
        questionContextOne.add("лежать");
        questionContextOne.add("говорить");
        questionContextOne.add("кидать");
        questionContextOne.add("укрывать");
        questionContextOne.add("есть");
        questionContextOne.add("ждать");
        questionContextOne.add("пользоваться");
    }

    private void initContextTwo(){
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
        questionContextTwo.add("");
    }

    public void initAll(){
        initContextOne();
        initContextTwo();
    }

}
