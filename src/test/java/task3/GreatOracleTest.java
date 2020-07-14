package task3;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GreatOracleTest {
    GreatOracle greatOracle = new GreatOracle();

    @Test
    public void sticks(){
        //assertTrue(greatOracle.sticks().contains("*Оракул ударил вас палкой*"));
    }

    @Test
    public void huff(){
        //assertTrue(TextConstants.curse.contains(greatOracle.huff()));

    }

    @Test(timeout = 62000)
    public void sleep() throws InterruptedException {
        greatOracle.sleepOracle(60000);
    }

    @Test
    public void questionLength(){
        String s1 = "Рмаогшкуцомшщауошщмавшщыоишгригшаовышщмошщавомывщшаримавгрмиашщвыомшщаоыщшмокищрщош";
        String s2 = "вуа";
        //assertEquals(greatOracle.questionLength(s1), TextConstants.situation.get(0));
        //assertEquals(greatOracle.questionLength(s2),  TextConstants.situation.get(1));

        //Как тестировать методы, результатом работы которых является System.out.println?
    }

    @Test
    public void giveAdvice(){
        String question1 = "слово";
        String question2 = "как когда почему";
        String question3 = "как";

        //assertEquals(greatOracle.giveAdvice(question1), "Не слышу вопроса в твоих речах.");
        //assertEquals(greatOracle.giveAdvice(question2), "Ты задаешь слишком много вопросов.");
        //assertEquals(greatOracle.giveAdvice(question3), TextConstants.questionAnswer.containsValue(question3));

    }

}