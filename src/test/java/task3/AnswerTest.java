package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerTest {

    @Test
    public void rudeness() {
        Answer answer = new Answer();
        assertEquals(answer.rudeness, answer.rudeness());
    }

    @Test
    public void stickHit() {
        Answer answer = new Answer();
        assertEquals(answer.stickHit, answer.stickHit());
    }

    @Test
    public void giveAnswer() {
        Answer answer = new Answer("Кто");
        String s = answer.giveAnswer();
        assertNotNull(s);
        assertTrue(s.length() > 0);
    }
}