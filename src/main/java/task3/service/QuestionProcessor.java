package task3.service;

import task3.model.Question;

public class QuestionProcessor {

    public boolean isLong(Question question) {
        return question.getContext().length() > Question.MAX_LENGTH;
    }

    public boolean isShort(Question question) {
        return question.getContext().length() < Question.MIN_LENGTH;
    }

    public boolean isContainsHardcodedWords(Question question) {
        String text = question.getContext().toLowerCase();
        String[] questionWords = question.getForbiddenWords();
        int counter = 0;
        for (String questionWord : questionWords) {
            int arrLength = text.split(questionWord).length;
            if (arrLength > 0)
                counter += arrLength;
        }
        return counter <= 1;
    }

    public boolean isEmpty(Question question) {
        return question == null || question.getContext()
                .replaceAll("\\s", "")
                .replaceAll("\\D", "")
                .isEmpty();
    }
}