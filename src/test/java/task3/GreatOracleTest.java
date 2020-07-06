package task3;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GreatOracleTest {
    GreatOracle greatOracle = new GreatOracle();

    @Test
    public void sticks(){
        assertTrue(greatOracle.sticks().contains("*Оракул ударил вас палкой*"));
    }

    @Test
    public void huff(){
        assertTrue(TextConstants.curse.contains(greatOracle.huff()));

    }

//    @Test(timeout = 60000)
//    public void sleep(){
//        greatOracle.sleep();
//    }
//
//    @Test
//    public void questionLength(){
//        int questionLengthSmall = 1;
//        int questionLengthLarge = 50;
//        assertTrue(greatOracle.questionLength(question) < questionLengthSmall);
//        assertTrue(greatOracle.questionLength(question) > questionLengthLarge);
//    }
//
//    @Test
//    public void questionQty(){
//        String question1 = "слово";
//        String question2 = "как когда почему";
//        String question3 = "как";
//
//        assertEquals(questionQty(question1), "Не слышу вопроса в твоих речах.");
//        assertEquals(questionQty(question2), "Ты задаешь слишком много вопросов.");
//        //assertEquals(questionQty(question3), TextConstants.questionAnswer.containsValue(question3));
//
//    }

}