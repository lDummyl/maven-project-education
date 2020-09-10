package task4;

import java.util.ArrayList;
import java.util.List;

public class Student {

    // TODO: 9/9/20 test driven development, test driven development jobamat'
    private int qtyQuestion;

    public List<String> keyQuestions = new ArrayList<>();

    public List<String> questionContextOne = new ArrayList<>();

    public List<String> questionContextTwo = new ArrayList<>();

    public void learning (List<String> wisdom){
        this.keyQuestions = wisdom;
    }

    public void initContextOne(){
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

    public void initContextTwo(){
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
