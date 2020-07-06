package task3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class TextConstantsTest {
    TextConstants textConstants = new TextConstants();
    Random random = new Random();

    @Test
    public void getAnswer(){
        assertEquals(textConstants.getAnswer("как"), "Хером об косяк!");
    }

    @Test
    public void getCurse(){
        int randomCurse = random.nextInt(TextConstants.curse.size());
        assertTrue(TextConstants.curse.contains(textConstants.getCurse(randomCurse)));
    }

}