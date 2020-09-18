package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {

    // TODO: 9/9/20 test driven development, test driven development jobamat'
    private int qtyQuestions;
    Random random = new Random();

    public Student(int qtyQuestion) {
        this.qtyQuestions = qtyQuestion;
    }

    public List<String> keyQuestions = new ArrayList<>();

    public List<String> questionContextOne = new ArrayList<>();

    public List<String> questionContextTwo = new ArrayList<>();

    // TODO: 9/18/20 заведи класс предложение и инкапсулируй туда все что с ним связано
    public void initKeyQuestions(){
        keyQuestions.add("как");
        keyQuestions.add("где");
        keyQuestions.add("когда");
        keyQuestions.add("почему");
        keyQuestions.add("зачем");
        keyQuestions.add("сколько");
        keyQuestions.add("откуда");
        keyQuestions.add("какой");
        keyQuestions.add("какая");
        keyQuestions.add("какое");
        keyQuestions.add("что");
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
        questionContextTwo.add("красиво?");
        questionContextTwo.add("гладко?");
        questionContextTwo.add("умело?");
        questionContextTwo.add("восхитительно?");
        questionContextTwo.add("академически?");
        questionContextTwo.add("жирно?");
        questionContextTwo.add("скользко?");
        questionContextTwo.add("нетривиально?");
        questionContextTwo.add("по-мужски?");
        questionContextTwo.add("дико?");
    }

    public void initAll(){
        initContextOne();
        initContextTwo();
        initKeyQuestions();
    }

    public String generatorQuestionOne(){
        int KQ = random.nextInt(keyQuestions.size());
        int CO = random.nextInt(questionContextOne.size());
        int CT = random.nextInt(questionContextTwo.size());

        return keyQuestions.get(KQ) + " " + questionContextOne.get(CO) + " " + questionContextTwo.get(CT);
    }

    public String generatorQuestion(){

        return keyQuestions.get(0) + " " + questionContextOne.get(0) + " " + questionContextTwo.get(0);
    }

    public List<String> generatorQuestions(){
        List<String> questions = new ArrayList<>();
        for(int i = 0; i < qtyQuestions; i++){
            questions.add(generatorQuestionOne());
        }
        return questions;
    }

}
