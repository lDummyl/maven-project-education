package task3;

import junit.framework.TestCase;

public class AnswerTest extends TestCase {

    public void testGetSpecialAnswer() {
        String any = "sdadas sadasdasd asdasd asdasd asd ad sa sasd asd adsd asd ";
        Question aaa = new Question(any);
        Answer antwort = new Answer(aaa);
        assertEquals(Answer.noKey , antwort.getSpecialAnswer());

        String anyTwo = "Когда sdadas sadasdasd asdasd asdasd asd ad sa sasd asd adsd asd Что";
        Question second = new Question(anyTwo);
        Answer antwortTwo = new Answer(second);
        assertEquals(Answer.moreKey , antwortTwo.getSpecialAnswer());


    }

    public void testLengthQCheck() {
        String longString = "sdadas sadasdasd asdasd asdasd asd ad sa sasd asd adsd asd ";
        Question questionLon = new Question(longString);
        Answer answerLon = new Answer(questionLon);
        assertEquals(Answer.tooLong, answerLon.lengthQCheck());


        String shortString = "sd";
        Question questionSh = new Question(shortString);
        Answer answerSh = new Answer(questionSh);
        assertEquals(Answer.tooShort, answerSh.lengthQCheck());
    }

    public void testGiveAnswer() {

    }
}