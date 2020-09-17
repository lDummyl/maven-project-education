package task4;

import org.junit.Test;
import org.mockito.Mockito;
import task3.Academy;

import static org.junit.Assert.*;

public class StudentTest {

    Student student = new Student(1000);

    @Test
    public void generatorQuestion() {
        student.initAll();
        // TODO: 9/11/20 забей ты пока на моки, все это моканье на данном этапе это так для общего понимания.
        //  Тест же задает контрект взаимодействия тестируемых узлов, а потом уже идет его реализация.

        String s = "как";
        String ss = "купить";
        String sss = "красиво";
        assertTrue(student.generatorQuestion().contains(s) && student.generatorQuestion().contains(ss) &&
                student.generatorQuestion().contains(sss));

    }

    //Как тестировать методы с вероятностью?
    @Test
    public void generatorQuestionOne(){
        student.initAll();
        boolean flagKeyQuestion = false;
        boolean flagContextOne = false;
        boolean flagContextTwo = false;
        String question = student.generatorQuestionOne();
        for (String s : student.keyQuestions) {
            if(question.contains(s)){
                flagKeyQuestion = true;
                break;
            }
        }
        for (String s : student.questionContextOne) {
            if(question.contains(s)){
                flagContextOne = true;
                break;
            }
        }
        for (String s : student.questionContextTwo) {
            if(question.contains(s)){
                flagContextTwo = true;
                break;
            }
        }
        assertTrue(flagKeyQuestion && flagContextOne && flagContextTwo);
    }

    @Test
    public void generatorQuestions(){
        student.initAll();
        assertTrue(student.generatorQuestions().size() == 1000);
    }


}