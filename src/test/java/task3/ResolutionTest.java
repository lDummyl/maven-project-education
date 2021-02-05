package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResolutionTest {
    @Test
    public void constructorTest(){
        Resolution resolution = new Resolution("some question", "some answer");
        resolution.setAnswer("sss");
        resolution.setQuestion("sds");

        assertNotNull(resolution.getQuestion());
        assertNotNull(resolution.getAnswer());
    }

}