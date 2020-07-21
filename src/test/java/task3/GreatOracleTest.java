package task3;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GreatOracleTest {
    GreatOracle greatOracle = new GreatOracle(10, 50);

    @Test
    public void learning(){
        greatOracle.learning(Academy.learnOracle1(11));
        assertEquals("Погугли.", greatOracle.wisdom.get("что"));
    }

    @Test
    public void questionLength(){
        String validLength = "строка нужной длины";
        assertEquals("строка нужной длины", greatOracle.questionLength(validLength));
    }

    @Test
    public void giveAnswer(){
        greatOracle.learning(Academy.learnOracle1(11));
        String s = "отсутствие вопроса в строке";
        assertEquals("Не слышу вопроса в твоих речах." ,greatOracle.giveAnswer(s));
        String ss = "!!как!,почему зачем,,,";
        assertEquals("Ты задаешь слишком много вопросов.", greatOracle.giveAnswer(ss));
        String sss = "что";
        assertEquals("Погугли.", greatOracle.giveAnswer(sss));
    }

    @Test
    public void say(){
        greatOracle.learning(Academy.learnOracle1(11));
        String s = "-1";
        assertEquals("Будь красноречивее!", greatOracle.say(s));
        String ss = "-2";
        assertEquals("Будь лаконичней.", greatOracle.say(ss));
        String sss = "???что,, такое осень";
        assertEquals("Погугли.", greatOracle.say(sss));
    }




}