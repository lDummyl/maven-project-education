package task3.service;

import task3.model.Question;

public class QuestionProcessor {

    public boolean isLong(Question question) {
        return question.getContext().length() > question.getMaxLength();
    }

    public boolean isShort(Question question) {
        return question.getContext().length() < question.getMinLength();
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
        return question.getContext().replaceAll("\\s", "").isEmpty();
    }
}