package task3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task3.model.Question;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionProcessorTest {

    private Question question;
    private QuestionProcessor qp;

    @BeforeEach
    void setup() {
        question = new Question();
        qp = new QuestionProcessor();
    }

    @Test
    void isLongerThanMaxLengthTest() {
        question.setContext("This test case contains of more than fifty symbols.");
        assertTrue(qp.isLong(question));
    }

    @Test
    void isShorterThanMinLengthTest() {
        question.setContext("Short one");
        assertTrue(qp.isShort(question));
    }

    @Test
    void isContainsHardcodedWordsTest() {
        question.setContext("Что Когда?");
        assertFalse(qp.isContainsHardcodedWords(question));
    }

    @Test
    void isEmptyOrNullTest() {
        question.setContext(" (){}[]/.,.$^&*");
        assertTrue(qp.isEmpty(question));
    }

}