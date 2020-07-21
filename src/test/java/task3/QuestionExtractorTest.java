package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionExtractorTest {

    QuestionExtractor questionExtractor = new QuestionExtractor(Academy.questionAnswer.keySet());

    @Test
    public void parse() {
        String s = "!!!Как,,, пройти в библиотеку";
        assertEquals("как", questionExtractor.parse123(s));
        String ss = "отсутствие вопроса";
        assertEquals("-10", questionExtractor.parse123(ss));
        String sss = "!!!как,,,когда     ....почему ";
        assertEquals("-20", questionExtractor.parse123(sss));

    }
}