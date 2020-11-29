package task3;

import junit.framework.TestCase;

public class QuestionTest extends TestCase {

    public void testGetKeyWort() {
    }

    public void testSpecialQuestCheck() {
        String noKey = "asdgg g erg ";


        for (String s : Question.specialQuests) {
            Question question = new Question(s + "asdgg g erg ");
            int expectedSize = 1;
            assertEquals(expectedSize, question.keyWort.size());
            assertEquals(s, question.getKeyWort().get(0));
        }

        for (int i = 0; i < Question.specialQuests.length - 1; i++) {
            int expectedSize = 2;
            Question question = new Question(Question.specialQuests[i] + "asdgg g erg " + Question.specialQuests[i + 1]);
            assertEquals(expectedSize, question.keyWort.size());
        }
    }

    // TODO: 29.11.2020 Сделать подробнее
    public void testGetQuestionText() {
        Question some = new Question("Что то там");
        assertEquals("Что то там", some.questionText);
    }

    public void testGetQuestionLength() {
        Question some = new Question("Что то там");
        assertEquals(10, some.questionLength);
    }

    public void testTestGetKeyWort() {
        Question some = new Question("Что то там");
        assertEquals("Что", some.getKeyWort().get(0));
    }
}