package task3.service;

import com.sun.xml.internal.ws.util.StringUtils;
import task3.model.Question;

import java.io.StringReader;

public class QuestionProcessor {

    public boolean isLong(Question question) {
        return question.getContext().length() > Question.MAX_LENGTH;
    }

    public boolean isShort(Question question) {
        return question.getContext().length() < Question.MIN_LENGTH;
    }

    public boolean isContainsHardcodedWords(Question question) {
        String text = question.getContext().toLowerCase();
        // TODO: 9/18/20 скорее искомые слова
        String[] questionWords = question.getForbiddenWords();
        int counter = 0;
        for (String questionWord : questionWords) {
            // TODO: 9/18/20 топором можно забивать говзди, но лучше знать где лежит мототок, в Apache Commons
            int arrLength = text.split(questionWord).length;
            if (arrLength > 0)
                counter += arrLength;
        }
        return counter <= 1;
    }

    // TODO: 9/18/20 там же
    public boolean isEmpty(Question question) {
        return question == null || question.getContext()
                .replaceAll("\\s", "")
                .replaceAll("\\D", "")
                .isEmpty();
    }
}